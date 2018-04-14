package com.mploed.dddwithspring.creditsalesfunnel.model.realEstate;

public enum Feature {
	SOLAR_COLLECTORS("Solar collectors"),
	PHOTOVOLTAICS("Photovoltaics"),
	SPA("Spa"),
	TWO_OR_MORE_BATHS("Two or more baths"),
	EV_CHARGER("Charger for electric vehicle"),
	POOL("Pool"),
	SUMMERHOUSE_IN_GARDEN("Summerhouse in the garden"),
	SAT_TV("Satellite TV");

	private final String displayName;

	Feature(String displayName) {
		this.displayName = displayName;
	}

	public String getDisplayName() {
		return displayName;
	}

}
