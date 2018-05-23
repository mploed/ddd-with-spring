package com.mploed.dddwithspring.creditagency.events.incoming;

import com.mploed.dddwithspring.creditagency.events.incoming.applicant.Applicant;

import java.util.Date;

public class ApplicationSubmittedEvent {
	private String applicationNumber;
	private Applicant firstApplicant;

	public ApplicationSubmittedEvent() {
	}

	public String getApplicationNumber() {
		return applicationNumber;
	}

	public void setApplicationNumber(String applicationNumber) {
		this.applicationNumber = applicationNumber;
	}

	public Applicant getFirstApplicant() {
		return firstApplicant;
	}

	public void setFirstApplicant(Applicant firstApplicant) {
		this.firstApplicant = firstApplicant;
	}

}
