package com.mploed.dddwithspring.scoring;

import com.mploed.dddwithspring.scoring.agencyResult.AgencyResultAggregate;
import com.mploed.dddwithspring.scoring.agencyResult.AgencyResultProjection;
import com.mploed.dddwithspring.scoring.agencyResult.AgencyResultRepository;
import com.mploed.dddwithspring.scoring.applicant.ApplicantAggregate;
import com.mploed.dddwithspring.scoring.applicant.ApplicantResultProjection;
import com.mploed.dddwithspring.scoring.applicant.ApplicantResultRepository;
import com.mploed.dddwithspring.scoring.events.incoming.*;
import com.mploed.dddwithspring.scoring.financialSituation.FinancialSituationAggregate;
import com.mploed.dddwithspring.scoring.financialSituation.FinancialSituationResultProjection;
import com.mploed.dddwithspring.scoring.financialSituation.FinancialSituationResultRepository;
import com.mploed.dddwithspring.scoring.scoringResult.ScoringResultAggregate;
import com.mploed.dddwithspring.scoring.scoringResult.ScoringResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		for(AgencyMessage message : agencyResultArrivedEvent.getWarningMessages()) {
			agencyResultBuilder.withWarning(message.getKey(), message.getMessageText());
		}
		for(AgencyMessage message : agencyResultArrivedEvent.getKoCriteria()) {
			agencyResultBuilder.withKoCriteria(message.getKey(), message.getMessageText());
		}

		AgencyResultAggregate agencyResultAggregate = agencyResultBuilder.build();

		agencyResultRepository.save(agencyResultAggregate);


	}

	public void scoreApplicant(ApplicantAddedEvent event){
		ApplicationNumber applicationNumber = new ApplicationNumber(event.getApplicationNumber());
		ApplicantAggregate applicantAggregate = new ApplicantAggregate.ApplicantAggregateBuilder(applicationNumber)
				.accountBalance(event.getAccountBalance())
				.city(event.getCity())
				.postCode(event.getPostCode())
				.firstName(event.getFirstName())
				.lastName(event.getLastName())
				.street(event.getStreet())
				.build();

		applicantResultRepository.save(applicantAggregate);

	}

	public void scoreFinancialSituation(FinancialSituationEnteredEvent event) {
		ApplicationNumber applicationNumber = new ApplicationNumber(event.getApplicationNumber());
		FinancialSituationAggregate financialSituationAggregate = new FinancialSituationAggregate.FinancialSituationBuilder(applicationNumber)
				.costOfLiving(event.getCostOfLiving())
				.otherIncome(event.getOtherIncome())
				.rent(event.getRent())
				.salary(event.getSalary())
				.build();

		financialSituationResultRepository.save(financialSituationAggregate);
	}

	public void performFinalScoring(ApplicationSubmittedEvent applicationSubmittedEvent) {
		ApplicationNumber applicationNumber = new ApplicationNumber(applicationSubmittedEvent.getApplicationNumber());

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
	};

}
