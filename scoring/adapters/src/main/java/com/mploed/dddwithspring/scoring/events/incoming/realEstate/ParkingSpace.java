package com.mploed.dddwithspring.scoring.events.incoming.realEstate;

public enum ParkingSpace {
	NOT_PRESENT("Not present"),
	CARPORT("Carport"),
	GARAGE("Garage");

	private final String displayName;

	ParkingSpace(String displayName) {
		this.displayName = displayName;
	}

	public String getDisplayName() {
		return displayName;
	}
}
