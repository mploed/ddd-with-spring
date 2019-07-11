package com.mploed.dddwithspring.scoring.appservices.internalevents;

import com.mploed.dddwithspring.scoring.ApplicationNumber;
import com.mploed.dddwithspring.scoring.PersonId;
import org.springframework.context.ApplicationEvent;

public class ScoringPerformed extends ApplicationEvent {
	private ApplicationNumber applicationNumber;
	private PersonId personId;
	private String scoreColor;
	private int points;

	public ScoringPerformed(Object source, String applicationNumber, PersonId personId, String scoreColor, int points) {
		super(source);
		this.applicationNumber = new ApplicationNumber(applicationNumber);
		this.personId = personId;
		this.scoreColor = scoreColor;
		this.points = points;
	}


	public ScoringPerformed(Object source, PersonId personId) {
		super(source);
		this.personId = personId;
	}



	public ScoringPerformed(Object source, ApplicationNumber applicationNumber) {
		super(source);
		this.applicationNumber = applicationNumber;
	}

	public ApplicationNumber getApplicationNumber() {
		return applicationNumber;
	}

	public PersonId getPersonId() {
		return personId;
	}

	public String getScoreColor() {
		return scoreColor;
	}

	public int getPoints() {
		return points;
	}
}
