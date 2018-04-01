package com.mploed.dddwithspring.scoring.financialSituation;

class Incomings {
	int salary;
	private int otherIncome;

	Incomings(int salary, int otherIncome) {
		this.salary = salary;
		this.otherIncome = otherIncome;
	}

	int sum() {
		return salary + otherIncome;
	}
}
