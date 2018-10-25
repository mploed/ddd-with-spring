package com.mploed.dddwithspring.creditagency.events.incoming.applicant;

import java.io.Serializable;
import java.util.Date;

public class Applicant implements Serializable {


	private String firstName;

	private String lastName;

	private Address address;

	private MaritalStatus maritalStatus;

	private Business business;

	private Employment employment;

	private Date employedSince;

	private Date birthday;


	public Applicant() {
		this.address = new Address();
	}

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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public MaritalStatus getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(MaritalStatus maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public Business getBusiness() {
		return business;
	}

	public void setBusiness(Business business) {
		this.business = business;
	}

	public Employment getEmployment() {
		return employment;
	}

	public void setEmployment(Employment employment) {
		this.employment = employment;
	}

	public Date getEmployedSince() {
		return employedSince;
	}

	public void setEmployedSince(Date employedSince) {
		this.employedSince = employedSince;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "Applicant{" +
				"firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", address=" + address +
				", maritalStatus=" + maritalStatus +
				", business=" + business +
				", employment=" + employment +
				", employedSince=" + employedSince +
				", birthday=" + birthday +
				'}';
	}
}
