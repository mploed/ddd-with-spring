package com.mploed.dddwithspring.scoring.incoming.applicant;

public enum Employment {
	EMPLOYEE("Employee"), OFFICIAL("Official"),
	PENSIONER("Pensioner"),
	STUDENT("Student"),
	TRAINEE("Trainee"),
	FREELANCER("Freelancer"),
	UNEMPLOYED("Unemployed"),
	OTHER("Other");

	private final String displayName;

	Employment(String displayName) {
		this.displayName = displayName;
	}

	public String getDisplayName() {
		return displayName;
	}
}
