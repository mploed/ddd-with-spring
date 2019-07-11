package com.mploed.dddwithspring.scoring.financialSituation;

import com.mploed.dddwithspring.scoring.Money;

class Incomings {
	Money salary;
	Money otherIncome;

	Incomings(Money salary, Money otherIncome) {
		this.salary = salary;
		this.otherIncome = otherIncome;
	}

	Money sum() {
		return salary.add(otherIncome);
	}
}
