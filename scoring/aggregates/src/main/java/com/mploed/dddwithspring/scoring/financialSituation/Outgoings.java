package com.mploed.dddwithspring.scoring.financialSituation;

import com.mploed.dddwithspring.scoring.Money;

class Outgoings {
	private Money rent;
	private Money costOfLiving;

	Outgoings(Money rent, Money costOfLiving) {
		this.rent = rent;
		this.costOfLiving = costOfLiving;
	}

	Money sum() {
		return rent.add(costOfLiving);
	}
}
