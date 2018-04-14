package com.mploed.dddwithspring.creditsalesfunnel.model.realEstate;

public enum ApartmentLocation {
	BASEMENT_FLOOR("Basement floor"),
	GROUND_FLOOR("Ground floor"),
	UPPER_FLOOR("Upper floor"),
	PENTHOUSE("Penthouse");

	private final String displayName;

	ApartmentLocation(String displayName) {
		this.displayName = displayName;
	}

	public String getDisplayName() {
		return displayName;
	}
}
