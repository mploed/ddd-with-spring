package com.mploed.dddwithspring.scoring.applicant;

class AccountBalance {
	private int balance;

	AccountBalance(int balance) {
		this.balance = balance;
	}

	int calculateScoringPoints() {
		if(balance > 8000) {
			return 10;
		} else {
			return 0;
		}
	}
}
