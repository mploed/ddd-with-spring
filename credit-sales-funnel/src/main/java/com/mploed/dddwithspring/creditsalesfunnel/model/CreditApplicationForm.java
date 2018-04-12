package com.mploed.dddwithspring.creditsalesfunnel.model;

import com.mploed.dddwithspring.creditsalesfunnel.model.applicant.Applicant;
import com.mploed.dddwithspring.creditsalesfunnel.model.financing.Financing;
import com.mploed.dddwithspring.creditsalesfunnel.model.household.Household;
import com.mploed.dddwithspring.creditsalesfunnel.model.realEstate.RealEstateProperty;

import java.io.Serializable;
import java.util.UUID;

public class CreditApplicationForm implements Serializable {
	private String applicationNumber;

	private Applicant firstApplicant;
	private Applicant secondApplicant;
	private RealEstateProperty realEstateProperty;
	private Household householdInformation;
	private Financing financing;

	public CreditApplicationForm() {
		this.applicationNumber = UUID.randomUUID().toString();
	}

	public String getApplicationNumber() {
		return applicationNumber;
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

	public RealEstateProperty getRealEstateProperty() {
		return realEstateProperty;
	}

	public void setRealEstateProperty(RealEstateProperty realEstateProperty) {
		this.realEstateProperty = realEstateProperty;
	}

	public Household getHouseholdInformation() {
		return householdInformation;
	}

	public void setHouseholdInformation(Household householdInformation) {
		this.householdInformation = householdInformation;
	}

	public Financing getFinancing() {
		return financing;
	}

	public void setFinancing(Financing financing) {
		this.financing = financing;
	}
}
