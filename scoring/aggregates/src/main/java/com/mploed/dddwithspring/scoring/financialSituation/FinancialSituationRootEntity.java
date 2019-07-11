package com.mploed.dddwithspring.scoring.financialSituation;


import com.mploed.dddwithspring.scoring.ApplicationNumber;
import com.mploed.dddwithspring.scoring.Money;

class FinancialSituationRootEntity {
	final ApplicationNumber applicationNumber;

	final Incomings incomings;
	final Outgoings outgoings;

	FinancialSituationRootEntity(ApplicationNumber applicationNumber, Incomings incomings, Outgoings outgoings) {
		this.applicationNumber = applicationNumber;
		this.incomings = incomings;
		this.outgoings = outgoings;
	}

	Money sum() {
		return incomings.sum().add(outgoings.sum());
	}

}
