package com.mploed.dddwithspring.scoring.financialSituation;

import com.mploed.dddwithspring.scoring.Money;

class Incomings {
	private Money salary;
	private Money otherIncome;

	Incomings(Money salary, Money otherIncome) {
		this.salary = salary;
		this.otherIncome = otherIncome;
	}

	Money sum() {
		return salary.add(otherIncome);
	}
}
