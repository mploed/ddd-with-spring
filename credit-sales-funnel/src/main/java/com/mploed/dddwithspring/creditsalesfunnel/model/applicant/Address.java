package com.mploed.dddwithspring.creditsalesfunnel.model.applicant;

import java.io.Serializable;

public class Address implements Serializable {
	private String street;
	private String postCode;
	private String city;

	public Address(String street, String postCode, String city) {
		this.street = street;
		this.postCode = postCode;
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public String getPostCode() {
		return postCode;
	}

	public String getCity() {
		return city;
	}
}
