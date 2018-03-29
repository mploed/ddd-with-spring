package com.mploed.dddwithspring.scoring.scoringResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ScoringResultJPARepository implements ScoringResultRepository {
	private ScoringResultDAO scoringResultDAO;

	@Autowired
	public ScoringResultJPARepository(ScoringResultDAO scoringResultDAO) {
		this.scoringResultDAO = scoringResultDAO;
	}

	@Override
	public void save(ScoringResultAggregate scoringResultAggregate) {


	}
}
