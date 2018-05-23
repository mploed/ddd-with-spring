package com.mploed.dddwithspring.scoring.events.incoming.financing;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

public class Loan implements Serializable {
	private Long databaseId;
	private int loanAmount;
	private int interestRate;
	private int repaymentInPercent;
	private int fixedInterestRateInYears;

	public Loan() {
		this.interestRate = 2;
	}

	public Long getDatabaseId() {
		return databaseId;
	}

	public void setDatabaseId(Long databaseId) {
		this.databaseId = databaseId;
	}

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
