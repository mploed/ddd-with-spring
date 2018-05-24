package com.mploed.dddwithspring.scoring;

import com.mploed.dddwithspring.scoring.agencyResult.AgencyResultAggregate;
import com.mploed.dddwithspring.scoring.agencyResult.AgencyResultProjection;
import com.mploed.dddwithspring.scoring.agencyResult.AgencyResultRepository;
import com.mploed.dddwithspring.scoring.applicant.ApplicantAggregate;
import com.mploed.dddwithspring.scoring.applicant.ApplicantResultProjection;
import com.mploed.dddwithspring.scoring.applicant.ApplicantResultRepository;
import com.mploed.dddwithspring.scoring.events.ScoringPerformed;
import com.mploed.dddwithspring.scoring.feeds.CreditAgencyPoller;
import com.mploed.dddwithspring.scoring.financialSituation.FinancialSituationAggregate;
import com.mploed.dddwithspring.scoring.financialSituation.FinancialSituationResultProjection;
import com.mploed.dddwithspring.scoring.financialSituation.FinancialSituationResultRepository;
import com.mploed.dddwithspring.scoring.incoming.AgencyMessage;
import com.mploed.dddwithspring.scoring.incoming.AgencyResultArrivedEvent;
import com.mploed.dddwithspring.scoring.incoming.ApplicationSubmittedEvent;
import com.mploed.dddwithspring.scoring.incoming.applicant.Applicant;
import com.mploed.dddwithspring.scoring.incoming.creditAgency.AgencyRating;
import com.mploed.dddwithspring.scoring.scoringResult.ScoringResultAggregate;
import com.mploed.dddwithspring.scoring.scoringResult.ScoringResultRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class ScoringApplicationService {
	private final Logger log = LoggerFactory.getLogger(ScoringApplicationService.class);

	private ScoringResultRepository scoringResultRepository;

	private AgencyResultRepository agencyResultRepository;

	private ApplicantResultRepository applicantResultRepository;

	private FinancialSituationResultRepository financialSituationResultRepository;


	private ApplicationEventPublisher applicationEventPublisher;

	@Autowired
	public ScoringApplicationService(ScoringResultRepository scoringResultRepository, AgencyResultRepository agencyResultRepository, ApplicantResultRepository applicantResultRepository, FinancialSituationResultRepository financialSituationResultRepository, ApplicationEventPublisher applicationEventPublisher) {
		this.scoringResultRepository = scoringResultRepository;
		this.agencyResultRepository = agencyResultRepository;
		this.applicantResultRepository = applicantResultRepository;
		this.financialSituationResultRepository = financialSituationResultRepository;
		this.applicationEventPublisher = applicationEventPublisher;
	}

	public void scoreAgencyResult(AgencyRating agencyRating) {
		AgencyResultAggregate.AgencyResultBuilder agencyResultBuilder = new AgencyResultAggregate.AgencyResultBuilder()
				.forPerson(agencyRating.getFirstName(),
						agencyRating.getLastName(),
						agencyRating.getStreet(),
						agencyRating.getPostCode(),
						agencyRating.getCity())
				.withPoints(agencyRating.getPoints());

		AgencyResultAggregate agencyResultAggregate = agencyResultBuilder.build();


		agencyResultRepository.save(agencyResultAggregate);

		ApplicantResultProjection applicantResultProjection = applicantResultRepository.retrieve(agencyResultAggregate.getPersonId());
		applicationEventPublisher.publishEvent(new ScoringPerformed(this, applicantResultProjection.getApplicationNumber()));
	}


	public void scoreApplication(ApplicationSubmittedEvent applicationSubmittedEvent) {
		ApplicationNumber applicationNumber = new ApplicationNumber(applicationSubmittedEvent.getApplicationNumber());

		try {
			scoreApplicant(applicationSubmittedEvent, applicationNumber);
			scoreFinancialSituation(applicationSubmittedEvent, applicationNumber);
			applicationEventPublisher.publishEvent(new ScoringPerformed(this, applicationSubmittedEvent.getApplicationNumber()));
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

		if(financialSituationResultProjection != null && applicantResultProjection !=null && agencyResultProjection != null) {

			log.info("everything is complete for " + applicationNumber.toString());
			ScoringResultAggregate scoringResultAggregate = new ScoringResultAggregate.Builder(applicationNumber)
					.noGoCriteria(agencyResultProjection.isNoGoPresent())
					.agencyScoring(agencyResultProjection.getPoints())
					.financialSituationScoring(financialSituationResultProjection.getPoints())
					.applicantScoring(applicantResultProjection.getPoints())
					.build();

			scoringResultRepository.save(scoringResultAggregate);
		} else {
			log.info("NOT everything is complete for " + applicationNumber.toString());

		}
	}

}
