package com.mploed.dddwithspring.scoring.events.incoming.household;

import java.io.Serializable;
import java.util.Objects;

public class Household implements Serializable {
	private Long databaseId;

	private String applicationNumber;

	private int adultsInHousehold;
	private int childrenInHousehold;

	private String iban;

	private String bic;

	private EarningCapacity earningCapacity;

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
