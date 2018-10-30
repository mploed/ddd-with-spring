package com.mploed.dddwithspring.scoring.appservices.internalevents;

import com.mploed.dddwithspring.scoring.ApplicationNumber;
import com.mploed.dddwithspring.scoring.PersonId;
import org.springframework.context.ApplicationEvent;

public class PartOfScoringPerformed extends ApplicationEvent {
	private ApplicationNumber applicationNumber;
	private PersonId personId;

	public PartOfScoringPerformed(Object source, String applicationNumber, PersonId personId) {
		super(source);
		this.applicationNumber = new ApplicationNumber(applicationNumber);
		this.personId = personId;
	}


	public PartOfScoringPerformed(Object source, PersonId personId) {
		super(source);
		this.personId = personId;
	}



	public PartOfScoringPerformed(Object source, ApplicationNumber applicationNumber) {
		super(source);
		this.applicationNumber = applicationNumber;
	}

	public ApplicationNumber getApplicationNumber() {
		return applicationNumber;
	}

	public PersonId getPersonId() {
		return personId;
	}
}
