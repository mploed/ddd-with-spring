package com.mploed.dddwithspring.scoring.appservices.dto;

import com.mploed.dddwithspring.scoring.Money;

public class FinancialSituation {
	private Money costOfLiving;
	private Money furtherIncome;
	private Money rent;
	private Money salary;

	public FinancialSituation(Money costOfLiving, Money furtherIncome, Money rent, Money salary) {
		this.costOfLiving = costOfLiving;
		this.furtherIncome = furtherIncome;
		this.rent = rent;
		this.salary = salary;
	}

	public Money getCostOfLiving() {
		return costOfLiving;
	}

	public Money getFurtherIncome() {
		return furtherIncome;
	}

	public Money getRent() {
		return rent;
	}

	public Money getSalary() {
		return salary;
	}
}
