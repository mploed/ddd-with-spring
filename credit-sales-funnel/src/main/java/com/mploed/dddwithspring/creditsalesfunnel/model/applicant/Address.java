package com.mploed.dddwithspring.creditsalesfunnel.model.applicant;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class Address implements Serializable {
	private String street;
	private String postCode;
	private String city;

	public String getStreet() {
		return street;
	}

	public String getPostCode() {
		return postCode;
	}

	public String getCity() {
		return city;
	}

	private void setStreet(String street) {
		this.street = street;
	}

	private void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	private void setCity(String city) {
		this.city = city;
	}
}
