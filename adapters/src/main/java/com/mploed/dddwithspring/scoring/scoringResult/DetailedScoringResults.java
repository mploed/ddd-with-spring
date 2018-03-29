package com.mploed.dddwithspring.scoring.scoringResult;

import javax.persistence.Embeddable;

@Embeddable
public class DetailedScoringResults {
	private int applicantScoringResult;
	private int financialSituationScoringResult;
	private int agencyScoringResult;
	private boolean noGoCriteriaPresent;

	public DetailedScoringResults(ScoringCalculationResults scoringCalculationResults) {
		this.applicantScoringResult = scoringCalculationResults.applicantScoringResult;
		this.financialSituationScoringResult = scoringCalculationResults.financialSituationScoringResult;
		this.agencyScoringResult = scoringCalculationResults.agencyScoringResult;
		this.noGoCriteriaPresent = scoringCalculationResults.noGoCriteriaPresent;
	}

	private DetailedScoringResults() {
	}

	public int getApplicantScoringResult() {
		return applicantScoringResult;
	}

	public int getFinancialSituationScoringResult() {
		return financialSituationScoringResult;
	}

	public int getAgencyScoringResult() {
		return agencyScoringResult;
	}

	public boolean isNoGoCriteriaPresent() {
		return noGoCriteriaPresent;
	}
}
