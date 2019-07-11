package com.mploed.dddwithspring.scoring.applicant;

import com.mploed.dddwithspring.scoring.Money;

import java.math.BigDecimal;

class AccountBalance {
	private Money balance;

	AccountBalance(BigDecimal balance) {
		this(new Money(balance));
	}
	AccountBalance(Money balance) {
		this.balance = balance;
	}

	int calculateScoringPoints() {
		if(balance.isGreaterThan(new Money(8000))) {
			return 10;
		} else {
			return 0;
		}
	}

	BigDecimal toBigDecimal() {
		return balance.getAmount();
	}
}
