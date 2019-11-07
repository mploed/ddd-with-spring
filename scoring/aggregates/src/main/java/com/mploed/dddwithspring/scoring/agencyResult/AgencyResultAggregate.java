package com.mploed.dddwithspring.scoring.agencyResult;




import com.mploed.dddwithspring.scoring.PersonId;
import com.mploed.dddwithspring.scoring.microarchitecture.Aggregate;
import com.mploed.dddwithspring.scoring.microarchitecture.AggregateBuilder;

import java.util.HashSet;
import java.util.Set;

@Aggregate
public class AgencyResultAggregate {
	private AgencyResultRootEntity agencyResultRootEntity;

	AgencyResultRootEntity getAgencyResultRootEntity() {
		return agencyResultRootEntity;
	}

	private AgencyResultAggregate(AgencyResultBuilder builder) {
		this.agencyResultRootEntity = new AgencyResultRootEntity(builder.personId, builder.points);
		this.agencyResultRootEntity.addAllKoCriteria(builder.koCriteria);
		this.agencyResultRootEntity.addAllWarningMessage(builder.warningMessages);
	}


	public PersonId getPersonId() {
		return agencyResultRootEntity.id;
	}
	public boolean isAcceptable() {
		return agencyResultRootEntity.isAcceptable();
	}

	public int calculateScoringPoints() {
		return agencyResultRootEntity.calculateScoringPoints();
	}

	@AggregateBuilder
	public static class AgencyResultBuilder {
		private int points;
		private final Set<KoCriteria> koCriteria;
		private final Set<WarningMessage> warningMessages;
		private PersonId personId;

		public AgencyResultBuilder() {
			this.koCriteria = new HashSet<KoCriteria>();
			this.warningMessages = new HashSet<WarningMessage>();
		}

		public AgencyResultBuilder withPoints(int points) {
			if(this.points > 0) {
				throw new IllegalArgumentException("You have already set points");
			}
			if(points <= 0 || points > 100) {
				throw new IllegalArgumentException("The points you set must be > 0 and <= 100 (any number between 1 and 100)");
			}
			this.points = points;
			return this;
		}

		public AgencyResultBuilder withWarning(String key, String message) {
			this.warningMessages.add(new WarningMessage(key, message));
			return this;
		}

		public AgencyResultBuilder withKoCriteria(String key, String message) {
			this.koCriteria.add(new KoCriteria(key, message));
			return this;
		}

		public AgencyResultBuilder personId(PersonId personId) {
			this.personId = personId;
			return this;
		}

		public AgencyResultBuilder forPerson(String firstName, String lastName, String street, String postCode, String city) {
			if(this.personId != null) {
				throw new IllegalArgumentException("You have already set a person");
			}
			this.personId = new PersonId.PersonIdBuilder(firstName, lastName)
					.city(city)
					.street(street)
					.postCode(postCode)
					.build();
			return this;
		}

		public AgencyResultAggregate build() {
			if(this.points <= 0) {
				throw new IllegalStateException("Please set points > 0 with the withPoints mehtod");
			}
			if(this.personId == null) {
				throw new IllegalStateException("Please set a person with the forPerson method");
			}
			return new AgencyResultAggregate(this);
		}

	}
}
