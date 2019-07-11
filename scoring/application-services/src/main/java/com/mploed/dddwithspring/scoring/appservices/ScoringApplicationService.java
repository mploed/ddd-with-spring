package com.mploed.dddwithspring.scoring.appservices;

import com.mploed.dddwithspring.scoring.ApplicationNumber;
import com.mploed.dddwithspring.scoring.agencyResult.AgencyResultAggregate;
import com.mploed.dddwithspring.scoring.appservices.repositories.AgencyResultRepository;
import com.mploed.dddwithspring.scoring.applicant.ApplicantAggregate;
import com.mploed.dddwithspring.scoring.appservices.repositories.ApplicantResultRepository;
import com.mploed.dddwithspring.scoring.appservices.dto.Applicant;
import com.mploed.dddwithspring.scoring.appservices.dto.CreditApplication;
import com.mploed.dddwithspring.scoring.appservices.dto.FinancialSituation;
import com.mploed.dddwithspring.scoring.appservices.internalevents.PartOfScoringPerformed;
import com.mploed.dddwithspring.scoring.financialSituation.FinancialSituationAggregate;
import com.mploed.dddwithspring.scoring.appservices.repositories.FinancialSituationResultRepository;
import com.mploed.dddwithspring.scoring.scoringResult.ScoringResultAggregate;
import com.mploed.dddwithspring.scoring.appservices.repositories.ScoringResultRepository;
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

	public void scoreAgencyResult(String firstName, String lastName, String street, String postcode, String city, int agencyPoints ) {
		AgencyResultAggregate.AgencyResultBuilder agencyResultBuilder = new AgencyResultAggregate.AgencyResultBuilder()
				.forPerson(firstName,
						lastName,
						street,
						postcode,
						city)

				.withPoints(agencyPoints);

		AgencyResultAggregate agencyResultAggregate = agencyResultBuilder.build();

		agencyResultRepository.save(agencyResultAggregate);

		ApplicantAggregate applicantAggregate = applicantResultRepository.retrieve(agencyResultAggregate.getPersonId());
		applicationEventPublisher.publishEvent(new PartOfScoringPerformed(this, applicantAggregate.getApplicationNumber()));
	}

	public void scoreApplication(CreditApplication creditApplication) {

		try {
			ApplicationNumber applicationNumber = creditApplication.getApplicationNumber();
			scoreApplicant(applicationNumber, creditApplication.getApplicant());
			scoreFinancialSituation(applicationNumber, creditApplication.getFinancialSituation());
			applicationEventPublisher.publishEvent(new PartOfScoringPerformed(this, applicationNumber));
		} catch (Throwable t) {
			t.printStackTrace();
		}

	}

	private void scoreFinancialSituation(ApplicationNumber applicationNumber, FinancialSituation financialSituation) {
		FinancialSituationAggregate financialSituationAggregate = new FinancialSituationAggregate.FinancialSituationBuilder(applicationNumber)
				.costOfLiving(financialSituation.getCostOfLiving())
				.otherIncome(financialSituation.getFurtherIncome())
				.rent(financialSituation.getRent())
				.salary(financialSituation.getSalary())
				.build();

		financialSituationResultRepository.save(financialSituationAggregate);
	}

	private void scoreApplicant(ApplicationNumber applicationNumber, Applicant applicant) {
		ApplicantAggregate applicantAggregate = new ApplicantAggregate.ApplicantAggregateBuilder(applicationNumber)
				.city(applicant.getCity())
				.postCode(applicant.getPostCode())
				.firstName(applicant.getFirstName())
				.lastName(applicant.getLastName())
				.street(applicant.getStreet())
				.build();

		applicantResultRepository.save(applicantAggregate);
	}

	public void performFinalScoring(ApplicationNumber applicationNumber) {
		FinancialSituationAggregate financialSituationAggregate = financialSituationResultRepository.retrieve(applicationNumber);
		ApplicantAggregate applicantAggregate = applicantResultRepository.retrieve(applicationNumber);
		AgencyResultAggregate agencyResultAggregate = agencyResultRepository.retrieve(applicantAggregate.getPersonId());

		if(financialSituationAggregate != null && applicantAggregate !=null && agencyResultAggregate != null) {

			log.info("everything is complete for " + applicationNumber.toString());
			ScoringResultAggregate scoringResultAggregate = new ScoringResultAggregate.Builder(applicationNumber)
					.noGoCriteria(!agencyResultAggregate.isAcceptable())
					.agencyScoring(agencyResultAggregate.calculateScoringPoints())
					.financialSituationScoring(financialSituationAggregate.calculateScoringPoints())
					.applicantScoring(applicantAggregate.calculateScoringPoints())
					.build();

			scoringResultRepository.save(scoringResultAggregate);
		} else {
			log.info("NOT everything is complete for " + applicationNumber.toString());

		}
	}

}
