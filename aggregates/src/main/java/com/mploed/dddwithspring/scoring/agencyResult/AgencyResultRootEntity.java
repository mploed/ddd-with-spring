package com.mploed.dddwithspring.scoring.agencyResult;


import com.mploed.dddwithspring.scoring.PersonId;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

class AgencyResultRootEntity {
	private final PersonId id;
	private final int points;
	private final Set<KoCriteria> koCriteria;
	private final Set<WarningMessage> warningMessages;

	AgencyResultRootEntity(PersonId id, int points) {
		this.id = id;
		this.points = points;
		this.koCriteria = new HashSet<KoCriteria>();
		this.warningMessages = new HashSet<WarningMessage>();
	}

	void addAllKoCriteria(Collection<KoCriteria> koCriteria) {
		this.koCriteria.addAll(koCriteria);
	}

	void addAllWarningMessage(Collection<WarningMessage> warningMessages) {
		this.warningMessages.addAll(warningMessages);
	}

	boolean isAcceptable() {
		if (koCriteria.size() > 0) {
			return false;
		} else if (warningMessages.size() > 5) {
			return false;
		} else {
			return true;
		}
	}

	int calculateScoringPoints() {
		int result = 0;
		if (warningMessages.size() == 0) {
			result += 5;
		}
		if (points > 90) {
			result += 15;
		} else if (points > 85) {
			result += 10;
		} else if (points > 80) {
			result += 5;
		}
		return result;
	}
}
