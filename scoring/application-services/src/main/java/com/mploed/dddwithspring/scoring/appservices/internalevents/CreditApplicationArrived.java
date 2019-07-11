package com.mploed.dddwithspring.scoring.appservices.internalevents;

import com.mploed.dddwithspring.scoring.ApplicationNumber;
import com.mploed.dddwithspring.scoring.PersonId;
import org.springframework.context.ApplicationEvent;

public class CreditApplicationArrived extends ApplicationEvent {
	private ApplicationNumber applicationNumber;

	public CreditApplicationArrived(Object source, String applicationNumber) {
		super(source);
		this.applicationNumber = new ApplicationNumber(applicationNumber);
	}


	public ApplicationNumber getApplicationNumber() {
		return applicationNumber;
	}

}
