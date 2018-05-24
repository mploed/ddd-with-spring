package com.mploed.dddwithspring.scoring.incoming.realEstate;

public enum ObjectType {
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
