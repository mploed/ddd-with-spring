package com.mploed.dddwithspring.scoring.appservices.internalevents;

import com.mploed.dddwithspring.scoring.ApplicationNumber;
import com.mploed.dddwithspring.scoring.PersonId;
import org.springframework.context.ApplicationEvent;

public class CreditAgencyResultArrived extends ApplicationEvent {
	private PersonId personId;

	public CreditAgencyResultArrived(Object source, String personId) {
		super(source);
		this.personId = new PersonId(personId);
	}

	public PersonId getPersonId() {
		return personId;
	}
}
