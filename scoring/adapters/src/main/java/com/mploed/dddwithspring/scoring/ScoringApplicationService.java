package com.mploed.dddwithspring.scoring;

import com.mploed.dddwithspring.scoring.agencyResult.AgencyResultAggregate;
import com.mploed.dddwithspring.scoring.agencyResult.AgencyResultProjection;
import com.mploed.dddwithspring.scoring.agencyResult.AgencyResultRepository;
import com.mploed.dddwithspring.scoring.applicant.ApplicantAggregate;
import com.mploed.dddwithspring.scoring.applicant.ApplicantResultProjection;
import com.mploed.dddwithspring.scoring.applicant.ApplicantResultRepository;
import com.mploed.dddwithspring.scoring.events.incoming.*;
import com.mploed.dddwithspring.scoring.events.incoming.applicant.Applicant;
import com.mploed.dddwithspring.scoring.events.incoming.household.Household;
import com.mploed.dddwithspring.scoring.financialSituation.FinancialSituationAggregate;
import com.mploed.dddwithspring.scoring.financialSituation.FinancialSituationResultProjection;
import com.mploed.dddwithspring.scoring.financialSituation.FinancialSituationResultRepository;
import com.mploed.dddwithspring.scoring.scoringResult.ScoringResultAggregate;
import com.mploed.dddwithspring.scoring.scoringResult.ScoringResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ScoringApplicationService {
	private ScoringResultRepository scoringResultRepository;

	private AgencyResultRepository agencyResultRepository;

	private ApplicantResultRepository applicantResultRepository;

	private FinancialSituationResultRepository financialSituationResultRepository;


	@Autowired
	public ScoringApplicationService(ScoringResultRepository scoringResultRepository, AgencyResultRepository agencyResultRepository, ApplicantResultRepository applicantResultRepository, FinancialSituationResultRepository financialSituationResultRepository) {
		this.scoringResultRepository = scoringResultRepository;
		this.agencyResultRepository = agencyResultRepository;
		this.applicantResultRepository = applicantResultRepository;
		this.financialSituationResultRepository = financialSituationResultRepository;
	}

	public void scoreAgencyResult(AgencyResultArrivedEvent agencyResultArrivedEvent) {
		AgencyResultAggregate.AgencyResultBuilder agencyResultBuilder = new AgencyResultAggregate.AgencyResultBuilder()
				.forPerson(agencyResultArrivedEvent.getFirstName(),
						agencyResultArrivedEvent.getLastName(),
						agencyResultArrivedEvent.getStreet(),
						agencyResultArrivedEvent.getPostCode(),
						agencyResultArrivedEvent.getCity())
				.withPoints(agencyResultArrivedEvent.getPoints());
		for (AgencyMessage message : agencyResultArrivedEvent.getWarningMessages()) {
			agencyResultBuilder.withWarning(message.getKey(), message.getMessageText());
		}
		for (AgencyMessage message : agencyResultArrivedEvent.getKoCriteria()) {
			agencyResultBuilder.withKoCriteria(message.getKey(), message.getMessageText());
		}

		AgencyResultAggregate agencyResultAggregate = agencyResultBuilder.build();

		agencyResultRepository.save(agencyResultAggregate);


	}


	public void scoreApplication(ApplicationSubmittedEvent applicationSubmittedEvent) {
		ApplicationNumber applicationNumber = new ApplicationNumber(applicationSubmittedEvent.getApplicationNumber());

		try {
			scoreApplicant(applicationSubmittedEvent, applicationNumber);


			scoreFinancialSituation(applicationSubmittedEvent, applicationNumber);
		} catch (Throwable t) {
			t.printStackTrace();
		}

	}

	private void scoreFinancialSituation(ApplicationSubmittedEvent applicationSubmittedEvent, ApplicationNumber applicationNumber) {
		FinancialSituationAggregate financialSituationAggregate = new FinancialSituationAggregate.FinancialSituationBuilder(applicationNumber)
				.costOfLiving(applicationSubmittedEvent.getHousehold().getMonthlyExpenses().getCostOfLiving())
				.otherIncome(applicationSubmittedEvent.getHousehold().getEarningCapacity().getFurtherIncome())
				.rent(applicationSubmittedEvent.getHousehold().getMonthlyExpenses().getRent())
				.salary(applicationSubmittedEvent.getHousehold().getEarningCapacity().getSalaryFirstApplicant())
				.build();

		financialSituationResultRepository.save(financialSituationAggregate);
	}

	private void scoreApplicant(ApplicationSubmittedEvent applicationSubmittedEvent, ApplicationNumber applicationNumber) {
		Applicant applicant = applicationSubmittedEvent.getFirstApplicant();
		ApplicantAggregate applicantAggregate = new ApplicantAggregate.ApplicantAggregateBuilder(applicationNumber)
				.city(applicant.getAddress().getCity())
				.postCode(applicant.getAddress().getPostCode())
				.firstName(applicant.getFirstName())
				.lastName(applicant.getLastName())
				.street(applicant.getAddress().getStreet())
				.build();

		applicantResultRepository.save(applicantAggregate);
	}

	public void performFinalScoring(ApplicationNumber applicationNumber) {
		FinancialSituationResultProjection financialSituationResultProjection = financialSituationResultRepository.retrieve(applicationNumber);
		ApplicantResultProjection applicantResultProjection = applicantResultRepository.retrieve(applicationNumber);
		AgencyResultProjection agencyResultProjection = agencyResultRepository.retrieve(new PersonId(applicantResultProjection.getPersonId()));

		ScoringResultAggregate scoringResultAggregate = new ScoringResultAggregate.Builder(applicationNumber)
				.noGoCriteria(agencyResultProjection.isNoGoPresent())
				.agencyScoring(agencyResultProjection.getPoints())
				.financialSituationScoring(financialSituationResultProjection.getPoints())
				.applicantScoring(applicantResultProjection.getPoints())
				.build();

		scoringResultRepository.save(scoringResultAggregate);
	}

}
