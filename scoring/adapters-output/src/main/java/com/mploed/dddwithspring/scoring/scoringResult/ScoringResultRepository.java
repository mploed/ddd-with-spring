package com.mploed.dddwithspring.scoring.scoringResult;

import com.mploed.dddwithspring.scoring.ApplicationNumber;

public interface ScoringResultRepository {
	void save(ScoringResultAggregate scoringResultAggregate);

	ScoringResultAggregate findByApplicationNumber(ApplicationNumber applicationNumber);
}
