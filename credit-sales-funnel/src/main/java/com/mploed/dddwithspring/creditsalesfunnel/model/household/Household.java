package com.mploed.dddwithspring.creditsalesfunnel.model.household;

import com.mploed.dddwithspring.creditsalesfunnel.model.validation.ApplicationSubmissionGroup;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Household implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long databaseId;

	@NotNull(groups = ApplicationSubmissionGroup.class)
	@NotEmpty(groups = ApplicationSubmissionGroup.class)
	private String applicationNumber;

	@Min(value = 1, groups = ApplicationSubmissionGroup.class)
	private int adultsInHousehold;
	private int childrenInHousehold;

	@NotNull(groups = ApplicationSubmissionGroup.class)
	@NotEmpty(groups = ApplicationSubmissionGroup.class)
	private String iban;

	private String bic;

	@Embedded
	@Valid
	@NotNull(groups = ApplicationSubmissionGroup.class)
	private EarningCapacity earningCapacity;

	@Embedded
	@Valid
	@NotNull(groups = ApplicationSubmissionGroup.class)
	private MonthlyExpenses monthlyExpenses;


	private Household() {
	}

	public Household(String applicationNumber) {
		this.earningCapacity = new EarningCapacity();
		this.monthlyExpenses = new MonthlyExpenses();
		this.applicationNumber = applicationNumber;
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Household household = (Household) o;
		return Objects.equals(applicationNumber, household.applicationNumber);
	}

	@Override
	public int hashCode() {

		return Objects.hash(applicationNumber);
	}

	public Long getDatabaseId() {
		return databaseId;
	}

	public void setDatabaseId(Long databaseId) {
		this.databaseId = databaseId;
	}

	public EarningCapacity getEarningCapacity() {
		return earningCapacity;
	}

	public void setEarningCapacity(EarningCapacity earningCapacity) {
		this.earningCapacity = earningCapacity;
	}

	public MonthlyExpenses getMonthlyExpenses() {
		return monthlyExpenses;
	}

	public void setMonthlyExpenses(MonthlyExpenses monthlyExpenses) {
		this.monthlyExpenses = monthlyExpenses;
	}

	public String getApplicationNumber() {
		return applicationNumber;
	}

	public int getAdultsInHousehold() {
		return adultsInHousehold;
	}

	public void setAdultsInHousehold(int adultsInHousehold) {
		this.adultsInHousehold = adultsInHousehold;
	}

	public int getChildrenInHousehold() {
		return childrenInHousehold;
	}

	public void setChildrenInHousehold(int childrenInHousehold) {
		this.childrenInHousehold = childrenInHousehold;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public String getBic() {
		return bic;
	}

	public void setBic(String bic) {
		this.bic = bic;
	}
}
