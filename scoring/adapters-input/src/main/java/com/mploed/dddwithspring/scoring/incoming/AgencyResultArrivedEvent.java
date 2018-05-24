package com.mploed.dddwithspring.scoring.incoming;


import java.util.Set;

public class AgencyResultArrivedEvent {
	private String firstName;
	private String lastName;
	private String street;
	private String postCode;
	private String city;

	private  int points;
	private  Set<AgencyMessage> koCriteria;
	private  Set<AgencyMessage> warningMessages;


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public Set<AgencyMessage> getKoCriteria() {
		return koCriteria;
	}

	public void setKoCriteria(Set<AgencyMessage> koCriteria) {
		this.koCriteria = koCriteria;
	}

	public Set<AgencyMessage> getWarningMessages() {
		return warningMessages;
	}

	public void setWarningMessages(Set<AgencyMessage> warningMessages) {
		this.warningMessages = warningMessages;
	}
}
