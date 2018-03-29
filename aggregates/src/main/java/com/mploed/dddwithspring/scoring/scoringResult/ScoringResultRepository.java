package com.mploed.dddwithspring.scoring.scoringResult;

public interface ScoringResultRepository {
	void save(ScoringResultAggregate scoringResultAggregate);
}
