package com.mploed.dddwithspring.scoring.financialSituation;

class Outgoings {
	private int rent;
	private int costOfLiving;

	Outgoings(int rent, int costOfLiving) {
		this.rent = rent;
		this.costOfLiving = costOfLiving;
	}

	int sum() {
		return rent + costOfLiving;
	}
}
