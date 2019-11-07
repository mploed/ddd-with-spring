package com.mploed.dddwithspring.scoring.appservices.internalevents;

import com.mploed.dddwithspring.scoring.ApplicationNumber;
import com.mploed.dddwithspring.scoring.PersonId;
import org.springframework.context.ApplicationEvent;

public class PartOfScoringPerformed extends ApplicationEvent {
	private ApplicationNumber applicationNumber;
	private PersonId personId;
	private String cluster;

	public PartOfScoringPerformed(Object source, String cluster, String applicationNumber, PersonId personId) {
		super(source);
		this.applicationNumber = new ApplicationNumber(applicationNumber);
		this.personId = personId;
	}


	public PartOfScoringPerformed(Object source, String cluster, PersonId personId) {
		super(source);
		this.personId = personId;
	}



	public PartOfScoringPerformed(Object source, String cluster, ApplicationNumber applicationNumber) {
		super(source);
		this.applicationNumber = applicationNumber;
		this.cluster = cluster;
	}

	public ApplicationNumber getApplicationNumber() {
		return applicationNumber;
	}

	public PersonId getPersonId() {
		return personId;
	}

	public String getCluster() {
		return cluster;
	}
}
