package com.mploed.dddwithspring.creditsalesfunnel.model.household;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class EarningCapacity implements Serializable {
	private int salaryFirstApplicant;
	private int salarySecondApplicant;
	private int rentalIncomeFinancedProperty;
	private int rentalIncomeOtherProperties;
	private int furtherIncome;
	private int childBenefit;
	private int assetsOnBankAccounts;
	private int assetsOther;

	public int getSalaryFirstApplicant() {
		return salaryFirstApplicant;
	}

	public void setSalaryFirstApplicant(int salaryFirstApplicant) {
		this.salaryFirstApplicant = salaryFirstApplicant;
	}

	public int getSalarySecondApplicant() {
		return salarySecondApplicant;
	}

	public void setSalarySecondApplicant(int salarySecondApplicant) {
		this.salarySecondApplicant = salarySecondApplicant;
	}

	public int getRentalIncomeFinancedProperty() {
		return rentalIncomeFinancedProperty;
	}

	public void setRentalIncomeFinancedProperty(int rentalIncomeFinancedProperty) {
		this.rentalIncomeFinancedProperty = rentalIncomeFinancedProperty;
	}

	public int getRentalIncomeOtherProperties() {
		return rentalIncomeOtherProperties;
	}

	public void setRentalIncomeOtherProperties(int rentalIncomeOtherProperties) {
		this.rentalIncomeOtherProperties = rentalIncomeOtherProperties;
	}

	public int getFurtherIncome() {
		return furtherIncome;
	}

	public void setFurtherIncome(int furtherIncome) {
		this.furtherIncome = furtherIncome;
	}

	public int getChildBenefit() {
		return childBenefit;
	}

	public void setChildBenefit(int childBenefit) {
		this.childBenefit = childBenefit;
	}

	public int getAssetsOnBankAccounts() {
		return assetsOnBankAccounts;
	}

	public void setAssetsOnBankAccounts(int assetsOnBankAccounts) {
		this.assetsOnBankAccounts = assetsOnBankAccounts;
	}

	public int getAssetsOther() {
		return assetsOther;
	}

	public void setAssetsOther(int assetsOther) {
		this.assetsOther = assetsOther;
	}
}
