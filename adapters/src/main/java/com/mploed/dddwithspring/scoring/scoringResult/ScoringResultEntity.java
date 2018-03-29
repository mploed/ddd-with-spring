package com.mploed.dddwithspring.scoring.scoringResult;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SCORING_RESULT")
public class ScoringResultEntity {
	@Id
	@GeneratedValue
	private Long id;

	private int scorePoints;

	private String scoreColor;

	private String applicationNumber;

	public ScoringResultEntity(int scorePoints, String scoreColor, String applicationNumber) {
		this.scorePoints = scorePoints;
		this.scoreColor = scoreColor;
		this.applicationNumber = applicationNumber;
	}

	private ScoringResultEntity() {
	}

	public Long getId() {
		return id;
	}

	public int getScorePoints() {
		return scorePoints;
	}

	public String getScoreColor() {
		return scoreColor;
	}

	public String getApplicationNumber() {
		return applicationNumber;
	}
}
