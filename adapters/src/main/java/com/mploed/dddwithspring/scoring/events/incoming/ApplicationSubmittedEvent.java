package com.mploed.dddwithspring.scoring.events.incoming;

public class ApplicationSubmittedEvent {
	private String applicationNumber;

	public String getApplicationNumber() {
		return applicationNumber;
	}

	public void setApplicationNumber(String applicationNumber) {
		this.applicationNumber = applicationNumber;
	}
}
