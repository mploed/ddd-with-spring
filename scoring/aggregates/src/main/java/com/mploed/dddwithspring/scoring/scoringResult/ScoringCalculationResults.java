package com.mploed.dddwithspring.scoring.scoringResult;

class ScoringCalculationResults {
	final int applicantScoringResult;
	final int financialSituationScoringResult;
	final int agencyScoringResult;
	final boolean noGoCriteriaPresent;

	ScoringCalculationResults(int applicantScoringResult, int financialSituationScoringResult, int agencyScoringResult, boolean noGoCriteriaPresent) {
		this.applicantScoringResult = applicantScoringResult;
		this.financialSituationScoringResult = financialSituationScoringResult;
		this.agencyScoringResult = agencyScoringResult;
		this.noGoCriteriaPresent = noGoCriteriaPresent;
	}

	OverallScoringResult calculateOverallResult() {
		int overallPoints = applicantScoringResult + financialSituationScoringResult + agencyScoringResult;
		ScoringColor color;

		if(noGoCriteriaPresent) {
			color = ScoringColor.RED;
		} else {
			if (overallPoints > 40) {
				color = ScoringColor.GREEN;
			} else if (overallPoints > 20) {
				color = ScoringColor.YELLOW;
			} else {
				color = ScoringColor.RED;
			}
		}
		return new OverallScoringResult(overallPoints, color);
	}
}
