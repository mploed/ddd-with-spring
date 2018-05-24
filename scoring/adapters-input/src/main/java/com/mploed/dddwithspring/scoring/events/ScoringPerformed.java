package com.mploed.dddwithspring.scoring.events;

import com.mploed.dddwithspring.scoring.PersonId;
import com.rometools.rome.feed.atom.Person;
import org.springframework.context.ApplicationEvent;

public class ScoringPerformed extends ApplicationEvent {
	private String applicationNumber;
	private PersonId personId;

	public ScoringPerformed(Object source, String applicationNumber, PersonId personId) {
		super(source);
		this.applicationNumber = applicationNumber;
		this.personId = personId;
	}


	public ScoringPerformed(Object source, PersonId personId) {
		super(source);
		this.personId = personId;
	}



	public ScoringPerformed(Object source, String applicationNumber) {
		super(source);
		this.applicationNumber = applicationNumber;
	}

	public String getApplicationNumber() {
		return applicationNumber;
	}

	public PersonId getPersonId() {
		return personId;
	}
}
