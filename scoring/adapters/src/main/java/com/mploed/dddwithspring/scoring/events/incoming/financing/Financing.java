package com.mploed.dddwithspring.scoring.events.incoming.financing;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Financing implements Serializable {
	private Long databaseId;

	private String applicationNumber;

	private int financingNeeds;

	private OwnResources ownResources;

	private PurchaseCosts purchaseCosts;

	private List<Loan> loans;

	public Financing(String applicationNumber) {
		this.applicationNumber = applicationNumber;
		this.ownResources = new OwnResources();
		this.purchaseCosts = new PurchaseCosts();
		this.loans = new ArrayList<Loan>(4);
		loans.add(new Loan());
		loans.add(new Loan());
		loans.add(new Loan());
		loans.add(new Loan());
	}

	public Financing() {
		this.ownResources = new OwnResources();
		this.purchaseCosts = new PurchaseCosts();
		this.loans = new ArrayList<Loan>(4);
		loans.add(new Loan());
		loans.add(new Loan());
		loans.add(new Loan());
		loans.add(new Loan());
	}

	public Long getDatabaseId() {
		return databaseId;
	}

	public void setDatabaseId(Long databaseId) {
		this.databaseId = databaseId;
	}

	public void setApplicationNumber(String applicationNumber) {
		this.applicationNumber = applicationNumber;
	}

	public String getApplicationNumber() {
		return applicationNumber;
	}

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
