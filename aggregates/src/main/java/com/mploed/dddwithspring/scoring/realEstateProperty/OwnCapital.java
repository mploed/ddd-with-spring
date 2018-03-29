package com.mploed.dddwithspring.scoring.realEstateProperty;

class OwnCapital {
	private int liquidAssets;
	private int creditBalancesFromTheBuildingSavingsSociety;
	private int ownManpower;

	OwnCapital(int liquidAssets, int creditBalancesFromTheBuildingSavingsSociety, int ownManpower) {
		this.liquidAssets = liquidAssets;
		this.creditBalancesFromTheBuildingSavingsSociety = creditBalancesFromTheBuildingSavingsSociety;
		this.ownManpower = ownManpower;
	}

	int sum() {
		return liquidAssets + creditBalancesFromTheBuildingSavingsSociety + ownManpower;
	}
}
