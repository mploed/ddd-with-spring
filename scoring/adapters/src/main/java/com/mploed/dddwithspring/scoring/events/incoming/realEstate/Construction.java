package com.mploed.dddwithspring.scoring.events.incoming.realEstate;

public enum Construction {
	PREFABRICATED_HOUSE("Prefabricated house"),
	WOOD("Wood"),
	STONE("Stone");

	private final String displayName;

	Construction(String displayName) {
		this.displayName = displayName;
	}

	public String getDisplayName() {
		return displayName;
	}
}
