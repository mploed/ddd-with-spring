package com.mploed.dddwithspring.scoring.scoringResult;

import org.springframework.data.jpa.repository.JpaRepository;

 interface ScoringResultDAO extends JpaRepository<ScoringResultEntity, Long> {
	ScoringResultEntity findByApplicationNumber(String applicationNumber);
}
