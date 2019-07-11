package com.mploed.dddwithspring.scoring.appservices.repositories;

import com.mploed.dddwithspring.scoring.ApplicationNumber;
import com.mploed.dddwithspring.scoring.scoringResult.ScoringResultAggregate;

public interface ScoringResultRepository {
	void save(ScoringResultAggregate scoringResultAggregate);

	ScoringResultAggregate findByApplicationNumber(ApplicationNumber applicationNumber);
}
