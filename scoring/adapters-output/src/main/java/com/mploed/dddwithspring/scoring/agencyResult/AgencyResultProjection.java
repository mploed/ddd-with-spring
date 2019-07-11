package com.mploed.dddwithspring.scoring.agencyResult;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.HashSet;
import java.util.Set;

@Entity
public class AgencyResultProjection {
	@Id
	@GeneratedValue
	private Long id;
	private String personId;
	private int points;

	@ElementCollection
	private Set<AgencyMessage> koCriteria = new HashSet<>();

	@ElementCollection
	private Set<AgencyMessage> warnings = new HashSet<>();

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

	public Set<AgencyMessage> getKoCriteria() {
		return koCriteria;
	}

	public void setKoCriteria(Set<AgencyMessage> koCriteria) {
		this.koCriteria = koCriteria;
	}

	public Set<AgencyMessage> getWarnings() {
		return warnings;
	}

	public void setWarnings(Set<AgencyMessage> warnings) {
		this.warnings = warnings;
	}

	public void addWarning(AgencyMessage agencyMessage) {
		this.warnings.add(agencyMessage);
	}

	public void addKoCriteria(AgencyMessage agencyMessage) {
		this.koCriteria.add(agencyMessage);
	}
}
