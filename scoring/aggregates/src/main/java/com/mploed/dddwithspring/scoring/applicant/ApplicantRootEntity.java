package com.mploed.dddwithspring.scoring.applicant;


import com.mploed.dddwithspring.scoring.ApplicationNumber;
import com.mploed.dddwithspring.scoring.PersonId;

class ApplicantRootEntity {
	final PersonId personId;
	final ApplicationNumber applicationNumber;
	private final String name;
	private final String lastName;
	private final Address address;
	private final AccountBalance balance;

	ApplicantRootEntity(PersonId personId, ApplicationNumber applicationNumber, String name, String lastName, Address address, AccountBalance balance) {

		this.personId = personId;
		this.applicationNumber = applicationNumber;
		this.name = name;
		this.lastName = lastName;
		this.address = address;
		this.balance = balance;
	}

	int calculateScoringPoints() {
		int result = 0;
		result += balance.calculateScoringPoints();
		result += address.calculateScoringPoints();
		return result;
	}
}
