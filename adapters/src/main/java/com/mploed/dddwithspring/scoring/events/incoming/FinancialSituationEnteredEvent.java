package com.mploed.dddwithspring.scoring.events.incoming;

import com.mploed.dddwithspring.scoring.ApplicationNumber;

public class FinancialSituationEnteredEvent {
	private String applicationNumber;
	private int rent;
	private int costOfLiving;
	private int salary;
	private int otherIncome;


	public String getApplicationNumber() {
		return applicationNumber;
	}

	public void setApplicationNumber(String applicationNumber) {
		this.applicationNumber = applicationNumber;
	}

	public int getRent() {
		return rent;
	}

	public void setRent(int rent) {
		this.rent = rent;
	}

	public int getCostOfLiving() {
		return costOfLiving;
	}

	public void setCostOfLiving(int costOfLiving) {
		this.costOfLiving = costOfLiving;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getOtherIncome() {
		return otherIncome;
	}

	public void setOtherIncome(int otherIncome) {
		this.otherIncome = otherIncome;
	}
}
