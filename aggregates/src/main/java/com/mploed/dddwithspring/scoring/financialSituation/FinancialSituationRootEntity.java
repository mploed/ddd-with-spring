package com.mploed.dddwithspring.scoring.financialSituation;


import com.mploed.dddwithspring.scoring.ApplicationNumber;

class FinancialSituationRootEntity {
	final ApplicationNumber applicationNumber;

	private final Incomings incomings;
	private final Outgoings outgoings;

	FinancialSituationRootEntity(ApplicationNumber applicationNumber, Incomings incomings, Outgoings outgoings) {
		this.applicationNumber = applicationNumber;
		this.incomings = incomings;
		this.outgoings = outgoings;
	}

	int sum() {
		return incomings.sum() - outgoings.sum();
	}

}
