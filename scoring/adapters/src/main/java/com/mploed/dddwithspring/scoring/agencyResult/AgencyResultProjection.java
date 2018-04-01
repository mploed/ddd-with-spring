package com.mploed.dddwithspring.scoring.agencyResult;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class AgencyResultProjection {
	@Id
	@GeneratedValue
	private Long id;
	private String personId;
	private int points;
	private boolean noGoPresent;

	private Long getId() {
		return id;
	}

	private void setId(Long id) {
		this.id = id;
	}

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public boolean isNoGoPresent() {
		return noGoPresent;
	}

	public void setNoGoPresent(boolean noGoPresent) {
		this.noGoPresent = noGoPresent;
	}
}
