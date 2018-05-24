package com.mploed.dddwithspring.scoring.incoming.realEstate;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

public class RealEstateProperty implements Serializable {
	private Long databaseId;
	private String applicationNumber;

	private String street;

	private String houseNumber;

	private String postCode;

	private String city;
	private String yearOfConstruction;

	private int livingSpaceSqm;
	private int landAreaSqm;

	private TypeOfUse typeOfUse;

	private ObjectType objectType;

	private UsageOfLoan usageOfLoan;

	private Construction construction;

	private Interior interior;

	private Attic attic;

	private Basement basement;

	private Set<Feature> features;

	private int numberOfFloors;

	private Date lastModernization;

	private ApartmentInformation apartmentInformation;

	public RealEstateProperty(String applicationNumber) {
		this.apartmentInformation = new ApartmentInformation();
		this.applicationNumber = applicationNumber;
	}

	private RealEstateProperty() {
		this.apartmentInformation = new ApartmentInformation();
	}

	public Long getDatabaseId() {
		return databaseId;
	}

	public void setDatabaseId(Long databaseId) {
		this.databaseId = databaseId;
	}

	public String getApplicationNumber() {
		return applicationNumber;
	}


	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
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

	public String getYearOfConstruction() {
		return yearOfConstruction;
	}

	public void setYearOfConstruction(String yearOfConstruction) {
		this.yearOfConstruction = yearOfConstruction;
	}

	public int getLivingSpaceSqm() {
		return livingSpaceSqm;
	}

	public void setLivingSpaceSqm(int livingSpaceSqm) {
		this.livingSpaceSqm = livingSpaceSqm;
	}

	public int getLandAreaSqm() {
		return landAreaSqm;
	}

	public void setLandAreaSqm(int landAreaSqm) {
		this.landAreaSqm = landAreaSqm;
	}

	public TypeOfUse getTypeOfUse() {
		return typeOfUse;
	}

	public void setTypeOfUse(TypeOfUse typeOfUse) {
		this.typeOfUse = typeOfUse;
	}

	public ObjectType getObjectType() {
		return objectType;
	}

	public void setObjectType(ObjectType objectType) {
		this.objectType = objectType;
	}

	public UsageOfLoan getUsageOfLoan() {
		return usageOfLoan;
	}

	public void setUsageOfLoan(UsageOfLoan usageOfLoan) {
		this.usageOfLoan = usageOfLoan;
	}

	public Construction getConstruction() {
		return construction;
	}

	public void setConstruction(Construction construction) {
		this.construction = construction;
	}

	public Interior getInterior() {
		return interior;
	}

	public void setInterior(Interior interior) {
		this.interior = interior;
	}

	public Attic getAttic() {
		return attic;
	}

	public void setAttic(Attic attic) {
		this.attic = attic;
	}

	public Basement getBasement() {
		return basement;
	}

	public void setBasement(Basement basement) {
		this.basement = basement;
	}

	public Set<Feature> getFeatures() {
		return features;
	}

	public void setFeatures(Set<Feature> features) {
		this.features = features;
	}

	public int getNumberOfFloors() {
		return numberOfFloors;
	}

	public void setNumberOfFloors(int numberOfFloors) {
		this.numberOfFloors = numberOfFloors;
	}

	public Date getLastModernization() {
		return lastModernization;
	}

	public void setLastModernization(Date lastModernization) {
		this.lastModernization = lastModernization;
	}

	public ApartmentInformation getApartmentInformation() {
		return apartmentInformation;
	}

	public void setApartmentInformation(ApartmentInformation apartmentInformation) {
		this.apartmentInformation = apartmentInformation;
	}
}
