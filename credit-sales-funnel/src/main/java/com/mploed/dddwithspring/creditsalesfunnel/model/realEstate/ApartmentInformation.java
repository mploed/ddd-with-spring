package com.mploed.dddwithspring.creditsalesfunnel.model.realEstate;

import com.mploed.dddwithspring.creditsalesfunnel.model.validation.ApplicationSubmissionGroup;

import javax.persistence.Embeddable;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Embeddable
public class ApartmentInformation implements Serializable {
	@Min(value = 1, groups = ApplicationSubmissionGroup.class)
	private int numberOfApartmentsInHouse;

	@NotNull(groups = ApplicationSubmissionGroup.class)
	@NotEmpty(groups = ApplicationSubmissionGroup.class)
	private String nameOfApartment;

	@NotNull(groups = ApplicationSubmissionGroup.class)
	private ApartmentLocation apartmentLocation;

	public int getNumberOfApartmentsInHouse() {
		return numberOfApartmentsInHouse;
	}

	public void setNumberOfApartmentsInHouse(int numberOfApartmentsInHouse) {
		this.numberOfApartmentsInHouse = numberOfApartmentsInHouse;
	}

	public String getNameOfApartment() {
		return nameOfApartment;
	}

	public void setNameOfApartment(String nameOfApartment) {
		this.nameOfApartment = nameOfApartment;
	}

	public ApartmentLocation getApartmentLocation() {
		return apartmentLocation;
	}

	public void setApartmentLocation(ApartmentLocation apartmentLocation) {
		this.apartmentLocation = apartmentLocation;
	}
}
