package com.mploed.dddwithspring.scoring.incoming.applicant;

public enum Business {
	BANKING("Banking"),
	ENERGY("Energy"),
	INSURANCE("Insurance"),
	CONSTRUCTION("Construction"),
	AGRICULTURE("Agriculture"),
	INDUSTRY("Industry"),
	PUBLIC_SERVICE("Public service"),
	OTHER("Other");

	private final String displayName;

	Business(String displayName) {
		this.displayName = displayName;
	}

	public String getDisplayName() {
		return displayName;
	}

}
