package com.mploed.dddwithspring.scoring.scoringResult;


import com.mploed.dddwithspring.scoring.ApplicationNumber;

class ScoringResultRootEntity {
	private ApplicationNumber applicationNumber;
	private OverallScoringResult overallScoringResult;
	private ScoringCalculationResults scoringCalculationResults;
	ScoringResultRootEntity(ApplicationNumber applicationNumber, int applicantScoringResult, int financialSituationScoringResult, int agencyScoringResult, boolean noGoCriteriaPresent) {
		this.applicationNumber = applicationNumber;
		this.scoringCalculationResults = new ScoringCalculationResults(applicantScoringResult, financialSituationScoringResult, agencyScoringResult, noGoCriteriaPresent);
		this.overallScoringResult = this.scoringCalculationResults.calculateOverallResult();
	}

	ApplicationNumber getApplicationNumber() {
		return applicationNumber;
	}

	OverallScoringResult getOverallScoringResult() {
		return overallScoringResult;
	}
}
