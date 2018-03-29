package com.mploed.dddwithspring.scoring.scoringResult;

class OverallScoringResult {
	private int points;
	private ScoringColor color;

	public OverallScoringResult(int points, ScoringColor color) {
		this.points = points;
		this.color = color;
	}

	int getPoints() {
		return points;
	}

	ScoringColor getColor() {
		return color;
	}
}
