package com.mploed.dddwithspring.scoring;

public class ApplicationNumber {
	private String applicationNumber;

	public ApplicationNumber(String applicationNumber) {
		this.applicationNumber = applicationNumber;
	}

	@Override
	public String toString() {
		return applicationNumber;
	}
}
