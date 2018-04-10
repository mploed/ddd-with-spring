package com.mploed.dddwithspring.creditsalesfunnel.model.financing;

import java.io.Serializable;
import java.util.List;

public class Financing implements Serializable {
	private int financingNeeds;
	private OwnResources ownResources;
	private PurchaseCosts purchaseCosts;
	private List<Loan> loans;

	public int getFinancingNeeds() {
		return financingNeeds;
	}

	public void setFinancingNeeds(int financingNeeds) {
		this.financingNeeds = financingNeeds;
	}

	public OwnResources getOwnResources() {
		return ownResources;
	}

	public void setOwnResources(OwnResources ownResources) {
		this.ownResources = ownResources;
	}

	public PurchaseCosts getPurchaseCosts() {
		return purchaseCosts;
	}

	public void setPurchaseCosts(PurchaseCosts purchaseCosts) {
		this.purchaseCosts = purchaseCosts;
	}

	public List<Loan> getLoans() {
		return loans;
	}

	public void setLoans(List<Loan> loans) {
		this.loans = loans;
	}
}
