package com.mploed.dddwithspring.scoring;

public class ApplicationNumber {
	private String applicatioNumber;

	public ApplicationNumber(String applicatioNumber) {
		this.applicatioNumber = applicatioNumber;
	}

	@Override
	public String toString() {
		return applicatioNumber;
	}
}
