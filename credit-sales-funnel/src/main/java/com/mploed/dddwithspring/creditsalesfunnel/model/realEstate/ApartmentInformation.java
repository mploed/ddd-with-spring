package com.mploed.dddwithspring.creditsalesfunnel.model.realEstate;

import java.io.Serializable;

public class ApartmentInformation implements Serializable {
	private int numberOfApartmentsInHouse;
	private String nameOfApartment;
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
