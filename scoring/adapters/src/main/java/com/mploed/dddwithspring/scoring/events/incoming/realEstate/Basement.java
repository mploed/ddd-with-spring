package com.mploed.dddwithspring.scoring.events.incoming.realEstate;

public enum Basement {
	NOT_PRESENT("Not present"),
	PARTLY_DEVELOPED("Partly developed"),
	FULLY_DEVELOPED("Fully developed");

	private final String displayName;

	Basement(String displayName) {
		this.displayName = displayName;
	}

	public String getDisplayName() {
		return displayName;
	}
}
