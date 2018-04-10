package com.mploed.dddwithspring.creditsalesfunnel.model.financing;

import java.io.Serializable;

public class Loan implements Serializable {
	private int loanAmount;
	private int interestRate;
	private int repaymentInPercent;
	private int fixedInterestRateInYears;

	public int getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(int loanAmount) {
		this.loanAmount = loanAmount;
	}

	public int getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(int interestRate) {
		this.interestRate = interestRate;
	}

	public int getRepaymentInPercent() {
		return repaymentInPercent;
	}

	public void setRepaymentInPercent(int repaymentInPercent) {
		this.repaymentInPercent = repaymentInPercent;
	}

	public int getFixedInterestRateInYears() {
		return fixedInterestRateInYears;
	}

	public void setFixedInterestRateInYears(int fixedInterestRateInYears) {
		this.fixedInterestRateInYears = fixedInterestRateInYears;
	}
}
