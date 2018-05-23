package com.mploed.dddwithspring.creditagency.events.incoming.applicant;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Applicant implements Serializable {


	private String firstName;

	private String lastName;

	private Address address;

	private MartialStatus martialStatus;

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

	public MartialStatus getMartialStatus() {
		return martialStatus;
	}

	public void setMartialStatus(MartialStatus martialStatus) {
		this.martialStatus = martialStatus;
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
				", martialStatus=" + martialStatus +
				", business=" + business +
				", employment=" + employment +
				", employedSince=" + employedSince +
				", birthday=" + birthday +
				'}';
	}
}
