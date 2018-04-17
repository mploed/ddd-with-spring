package com.mploed.dddwithspring.creditsalesfunnel.model.realEstate;

import com.mploed.dddwithspring.creditsalesfunnel.model.validation.ApplicationSubmissionGroup;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
public class RealEstateProperty implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long databaseId;
	@NotNull(groups = ApplicationSubmissionGroup.class)
	@NotEmpty(groups = ApplicationSubmissionGroup.class)
	private String applicationNumber;

	@NotNull(groups = ApplicationSubmissionGroup.class)
	@NotEmpty(groups = ApplicationSubmissionGroup.class)
	private String street;

	@NotNull(groups = ApplicationSubmissionGroup.class)
	@NotEmpty(groups = ApplicationSubmissionGroup.class)
	private String houseNumber;

	@NotNull(groups = ApplicationSubmissionGroup.class)
	@NotEmpty(groups = ApplicationSubmissionGroup.class)
	private String postCode;

	@NotNull(groups = ApplicationSubmissionGroup.class)
	@NotEmpty(groups = ApplicationSubmissionGroup.class)
	private String city;
	private String yearOfConstruction;

	private int livingSpaceSqm;
	private int landAreaSqm;

	@NotNull(groups = ApplicationSubmissionGroup.class)
	private TypeOfUse typeOfUse;

	@NotNull(groups = ApplicationSubmissionGroup.class)
	private ObjectType objectType;

	@NotNull(groups = ApplicationSubmissionGroup.class)
	private UsageOfLoan usageOfLoan;

	@NotNull(groups = ApplicationSubmissionGroup.class)
	private Construction construction;

	@NotNull(groups = ApplicationSubmissionGroup.class)
	private Interior interior;

	@NotNull(groups = ApplicationSubmissionGroup.class)
	private Attic attic;

	@NotNull(groups = ApplicationSubmissionGroup.class)
	private Basement basement;

	@ElementCollection
	private Set<Feature> features;

	private int numberOfFloors;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date lastModernization;

	@Embedded
	@Valid
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
