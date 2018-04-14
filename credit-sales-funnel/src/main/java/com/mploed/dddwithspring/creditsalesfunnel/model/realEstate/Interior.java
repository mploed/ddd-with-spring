package com.mploed.dddwithspring.creditsalesfunnel.model.realEstate;

public enum Interior {
	STANDARD("Standard"),
	LUXURY("Luxury"),
	SIMPLE("Simple");

	private final String displayName;

	Interior(String displayName) {
		this.displayName = displayName;
	}

	public String getDisplayName() {
		return displayName;
	}
}
