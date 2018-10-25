package com.mploed.dddwithspring.scoring.incoming.applicant;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Applicant implements Serializable {
	private Long databaseId;

	private String applicationNumber;

	private String applicantNumber;

	private String customerNumber;

	private String firstName;

	private String lastName;

	private Address address;

	private MaritalStatus maritalStatus;

	private Business business;

	private Employment employment;

	private String employer;

	private Date employedSince;

	private Date birthday;

	public Applicant(String applicationNumber, String applicantNumber) {
		this.address = new Address();
		this.applicationNumber = applicationNumber;
		this.applicantNumber = applicantNumber;
	}

	public Applicant() {
		this.address = new Address();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Applicant applicant = (Applicant) o;
		return Objects.equals(applicationNumber, applicant.applicationNumber) &&
				Objects.equals(applicantNumber, applicant.applicantNumber);
	}

	@Override
	public int hashCode() {

		return Objects.hash(applicationNumber, applicantNumber);
	}

	public Long getDatabaseId() {
		return databaseId;
	}

	public void setDatabaseId(Long databaseId) {
		this.databaseId = databaseId;
	}

	public String getApplicantNumber() {
		return applicantNumber;
	}

	public void setApplicantNumber(String applicantNumber) {
		this.applicantNumber = applicantNumber;
	}

	public String getApplicationNumber() {
		return applicationNumber;
	}

	public void setApplicationNumber(String applicationNumber) {
		this.applicationNumber = applicationNumber;
	}

	public String getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
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

	public String getEmployer() {
		return employer;
	}

	public void setEmployer(String employer) {
		this.employer = employer;
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


}
