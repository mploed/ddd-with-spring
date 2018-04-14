package com.mploed.dddwithspring.creditsalesfunnel.model.realEstate;

public enum ObjectType {
	LAND("Land"),
	SEMI_DETACHED_HOUSE("Semi detached house"),
	ROW_HOUSE("Row house"),
	DETACHED_HOUSE("Detached house"),
	APARTMENT("Apartment");

	private final String displayName;

	ObjectType(String displayName) {
		this.displayName = displayName;
	}

	public String getDisplayName() {
		return displayName;
	}
}
