package com.mploed.dddwithspring.scoring.appservices.dto;

public class Applicant {
	private String firstName;
	private String lastName;
	private String street;
	private String postCode;
	private String city;

	public Applicant(String firstName, String lastName, String street, String postCode, String city) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.street = street;
		this.postCode = postCode;
		this.city = city;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
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
