package com.mploed.dddwithspring.scoring.realEstateProperty;

class Loan {
	private final int fixedInterestRateInYears;
	private final int amount;
	private final int monthlyRedemptionPayment;

	Loan(int fixedInterestRateInYears, int amount, int monthlyPayement) {
		this.fixedInterestRateInYears = fixedInterestRateInYears;
		this.amount = amount;
		this.monthlyRedemptionPayment = monthlyPayement;
	}

	int getAmount() {
		return amount;
	}

	int getMonthlyRedemptionPayment() {
		return monthlyRedemptionPayment;
	}
}
