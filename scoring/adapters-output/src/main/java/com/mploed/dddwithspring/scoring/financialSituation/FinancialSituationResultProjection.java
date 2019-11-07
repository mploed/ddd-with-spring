package com.mploed.dddwithspring.scoring.financialSituation;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class FinancialSituationResultProjection {
	@Id
	@GeneratedValue
	private Long id;
	private String applicationNumber;

	private BigDecimal incomingOther;
	private BigDecimal incomingSalary;

	private BigDecimal outgoingRent;
	private BigDecimal outgoingCostOfLiving;

	Long getId() {
		return id;
	}

	void setId(Long id) {
		this.id = id;
	}

	String getApplicationNumber() {
		return applicationNumber;
	}

	void setApplicationNumber(String applicationNumber) {
		this.applicationNumber = applicationNumber;
	}

	BigDecimal getIncomingOther() {
		return incomingOther;
	}

	void setIncomingOther(BigDecimal incomingOther) {
		this.incomingOther = incomingOther;
	}

	BigDecimal getIncomingSalary() {
		return incomingSalary;
	}

	void setIncomingSalary(BigDecimal incomingSalary) {
		this.incomingSalary = incomingSalary;
	}

	BigDecimal getOutgoingRent() {
		return outgoingRent;
	}

	void setOutgoingRent(BigDecimal outgoingRent) {
		this.outgoingRent = outgoingRent;
	}

	BigDecimal getOutgoingCostOfLiving() {
		return outgoingCostOfLiving;
	}

	void setOutgoingCostOfLiving(BigDecimal outgoingCostOfLiving) {
		this.outgoingCostOfLiving = outgoingCostOfLiving;
	}
}
