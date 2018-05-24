package com.mploed.dddwithspring.scoring.incoming;

import com.mploed.dddwithspring.scoring.incoming.applicant.Applicant;
import com.mploed.dddwithspring.scoring.incoming.financing.Financing;
import com.mploed.dddwithspring.scoring.incoming.household.Household;
import com.mploed.dddwithspring.scoring.incoming.realEstate.RealEstateProperty;

import java.util.Date;

public class ApplicationSubmittedEvent {
	private String applicationNumber;
	private Date timestamp;
	private Applicant firstApplicant;
	private Applicant secondApplicant;
	private Household household;
	private RealEstateProperty realEstateProperty;
	private Financing financing;

	public ApplicationSubmittedEvent() {
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
