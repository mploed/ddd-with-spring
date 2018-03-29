package com.mploed.dddwithspring.scoring.realEstateProperty;

import java.util.List;

class FinancingOption {
	private String id;
	private List<Loan> loans;
	private OwnCapital ownCapital;

	FinancingOption(String id, List<Loan> loans, OwnCapital ownCapital) {
		this.id = id;
		this.loans = loans;
		this.ownCapital = ownCapital;
	}

	int getSumOfDebt() {
		int sumOfDebt = 0;
		for (Loan loan : loans) {
			sumOfDebt += loan.getAmount();
		}
		return sumOfDebt;
	}

	int getMonthlyRedemptionPayment() {
		int monthlyRedemptionPayment = 0;
		for(Loan loan : loans) {
			monthlyRedemptionPayment += loan.getMonthlyRedemptionPayment();
		}
		return monthlyRedemptionPayment;
	}


	String getId() {
		return id;
	}
}
