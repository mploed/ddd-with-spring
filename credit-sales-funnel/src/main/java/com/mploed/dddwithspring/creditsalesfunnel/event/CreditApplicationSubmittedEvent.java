package com.mploed.dddwithspring.creditsalesfunnel.event;

import com.mploed.dddwithspring.creditsalesfunnel.model.applicant.Applicant;
import com.mploed.dddwithspring.creditsalesfunnel.model.financing.Financing;
import com.mploed.dddwithspring.creditsalesfunnel.model.household.Household;
import com.mploed.dddwithspring.creditsalesfunnel.model.realEstate.RealEstateProperty;

import java.io.Serializable;
import java.util.Date;

public class CreditApplicationSubmittedEvent implements Serializable {
	private String applicationNumber;
	private Date timestamp;
	private Applicant firstApplicant;
	private Applicant secondApplicant;
	private Household household;
	private RealEstateProperty realEstateProperty;
	private Financing financing;


	public CreditApplicationSubmittedEvent() {
		this.timestamp = new Date();
	}

	public String getApplicationNumber() {
		return applicationNumber;
	}

	public void setApplicationNumber(String applicationNumber) {
		this.applicationNumber = applicationNumber;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public Applicant getFirstApplicant() {
		return firstApplicant;
	}

	public void setFirstApplicant(Applicant firstApplicant) {
		this.firstApplicant = firstApplicant;
	}

	public Applicant getSecondApplicant() {
		return secondApplicant;
	}

	public void setSecondApplicant(Applicant secondApplicant) {
		this.secondApplicant = secondApplicant;
	}

	public Household getHousehold() {
		return household;
	}

	public void setHousehold(Household household) {
		this.household = household;
	}

	public RealEstateProperty getRealEstateProperty() {
		return realEstateProperty;
	}

	public void setRealEstateProperty(RealEstateProperty realEstateProperty) {
		this.realEstateProperty = realEstateProperty;
	}

	public Financing getFinancing() {
		return financing;
	}

	public void setFinancing(Financing financing) {
		this.financing = financing;
	}
}
