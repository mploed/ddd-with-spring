package com.mploed.dddwithspring.scoring.scoringResult;

import javax.persistence.*;

@Entity
@Table(name = "SCORING_RESULT")
public class ScoringResultEntity {
	@Id
	@GeneratedValue
	private Long id;

	private String applicationNumber;

	private int scorePoints;

	private String scoreColor;

	@Embedded
	private DetailedScoringResults detailedScoringResults;

	public ScoringResultEntity(String applicationNumber, int scorePoints, String scoreColor, DetailedScoringResults detailedScoringResults) {
		this.applicationNumber = applicationNumber;
		this.scorePoints = scorePoints;
		this.scoreColor = scoreColor;
		this.detailedScoringResults = detailedScoringResults;
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

	public DetailedScoringResults getDetailedScoringResults() {
		return detailedScoringResults;
	}
}
