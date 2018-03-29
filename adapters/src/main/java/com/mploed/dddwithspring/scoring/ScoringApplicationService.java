package com.mploed.dddwithspring.scoring;


import com.mploed.dddwithspring.scoring.agencyResult.AgencyResultAggregate;
import com.mploed.dddwithspring.scoring.applicant.ApplicantAggregate;
import com.mploed.dddwithspring.scoring.financialSituation.FinancialSituationAggregate;
import com.mploed.dddwithspring.scoring.scoringResult.ScoringResultAggregate;

/**
 * This service aims to show how working with various aggregates can be implemented using application services.
 *
 * This class is also a very good starting point for taking a look at the public APIs of the aggregates.
 */
public class ScoringApplicationService {
	public ScoringResultAggregate performScoring(ApplicationNumber applicationNumber) {
		// Load an AgencyRe.sultAggregate
		AgencyResultAggregate agencyResultAggregate = loadAgencyResult();

		// Load an ApplicantAggregate
		ApplicantAggregate applicantAggregate = loadApplicant(applicationNumber);


		// Load a FinancialSituationAggregate
		FinancialSituationAggregate financialSituationAggregate = loadFinancialSituation(applicationNumber);


		return performScoringOnAggregates(applicationNumber, agencyResultAggregate, applicantAggregate, financialSituationAggregate);
	}

	ScoringResultAggregate performScoringOnAggregates(ApplicationNumber applicationNumber, AgencyResultAggregate agencyResultAggregate, ApplicantAggregate applicantAggregate, FinancialSituationAggregate financialSituationAggregate) {
		// Perform Scoring on Financial Situation Aggregate
		int financialSituationPoints = financialSituationAggregate.calculateScoringPoints();


		// Perform Scoring on ApplicantAggregate
		int applicantPoints = applicantAggregate.calculateScoringPoints();

		//Perform Scoring on the AgencyResultAggregate
		int agencyPoints = agencyResultAggregate.calculateScoringPoints();
		boolean noGoPresent = agencyResultAggregate.isAcceptable();




		ScoringResultAggregate scoringResultAggregate = new ScoringResultAggregate.Builder(applicationNumber)
				.agencyScoring(agencyPoints)
				.applicantScoring(applicantPoints)
				.financialSituationScoring(financialSituationPoints)
				.noGoCriteria(noGoPresent)
				.build();



		return scoringResultAggregate;
	}

	/**
	 * Method that simulates the retrieval of an AgencyResultAggregate. This would usually be done with a Respository
	 * (which is not the scope of this demo project)
	 *
	 * @return a fully initialized AgencyResultAggregate
	 */
	private AgencyResultAggregate loadAgencyResult() {
		return new AgencyResultAggregate.AgencyResultBuilder()
				.forPerson("Michael", "Plöd", "Kreuzstrasse 16", "80331", "Munich")
				.withPoints(80)
				.withWarning("100", "Did not pay his last bill at the restaurant")
				.build();

	}

	/**
	 * Method that simulates the retrieval of an ApplicantAggregate. This would usually be done with a Respository
	 * (which is not the scope of this demo project)
	 *
	 * @return a fully initialized ApplicantAggregate
	 */
	private ApplicantAggregate loadApplicant(ApplicationNumber applicationNumber) {
		return new ApplicantAggregate.ApplicantAggregateBuilder(applicationNumber)
				.city("Munich")
				.firstName("Michael")
				.lastName("Plöd")
				.postCode("80331")
				.street("Kreuzstrasse 16")
				.accountBalance(12000)
				.build();

	}


	/**
	 * Method that simulates the retrieval of an FinancialSituationAggregate. This would usually be done with a Respository
	 * (which is not the scope of this demo project)
	 *
	 * @return a fully initialized FinancialSituationAggregate
	 */
	private FinancialSituationAggregate loadFinancialSituation(ApplicationNumber applicationNumber) {
		return new FinancialSituationAggregate.FinancialSituationBuilder(applicationNumber)
				.salary(2500)
				.rent(800)
				.otherIncome(200)
				.costOfLiving(400)
				.build();
	}
}
