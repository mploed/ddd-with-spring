package com.mploed.dddwithspring.scoring.applicant;

class Address {
	private String city;
	private String postCode;
	private String street;

	Address(String street, String postCode, String city) {
		this.city = city;
		this.postCode = postCode;
		this.street = street;
	}

	int calculateScoringPoints() {
		if("Munich".equals(city)) {
			return 5;
		} else if ("Dortmund".equals(city)) {
			return -2;
		} else {
			return 0;
		}
	}

	String getCity() {
		return city;
	}

	String getPostCode() {
		return postCode;
	}

	String getStreet() {
		return street;
	}
}
