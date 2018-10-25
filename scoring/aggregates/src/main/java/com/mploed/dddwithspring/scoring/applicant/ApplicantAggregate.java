package com.mploed.dddwithspring.scoring.applicant;


import com.mploed.dddwithspring.scoring.ApplicationNumber;
import com.mploed.dddwithspring.scoring.Money;
import com.mploed.dddwithspring.scoring.PersonId;
import com.mploed.dddwithspring.scoring.microarchitecture.Aggregate;
import com.mploed.dddwithspring.scoring.microarchitecture.AggregateBuilder;

@Aggregate
public class ApplicantAggregate {
	 ApplicantRootEntity applicantRootEntity;


	private ApplicantAggregate(ApplicantAggregateBuilder builder) {
		PersonId personId = new PersonId.PersonIdBuilder(builder.firstName, builder.lastName)
				.postCode(builder.postCode)
				.city(builder.city)
				.street(builder.street)
				.build();

		Address address = new Address(builder.street, builder.postCode, builder.city);
		this.applicantRootEntity = new ApplicantRootEntity(personId,
				builder.applicationNumber,
				builder.firstName,
				builder.lastName,
				address,
				builder.accountBalance);

	}

	public int calculateScoringPoints() {
		return applicantRootEntity.calculateScoringPoints();
	}

	@AggregateBuilder
	public static class ApplicantAggregateBuilder {
		private String firstName;
		private String lastName;
		private final ApplicationNumber applicationNumber;
		private String street;
		private String postCode;
		private String city;
		private AccountBalance accountBalance;


		public ApplicantAggregateBuilder(ApplicationNumber applicationNumber) {
			this.applicationNumber = applicationNumber;
		}

		public ApplicantAggregateBuilder firstName(String firstName) {
			this.firstName = firstName;
			return this;
		}

		public ApplicantAggregateBuilder lastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		public ApplicantAggregateBuilder street(String street) {
			this.street = street;
			return this;
		}

		public ApplicantAggregateBuilder postCode(String postCode) {
			this.postCode = postCode;
			return this;
		}

		public ApplicantAggregateBuilder city(String city) {
			this.city = city;
			return this;
		}

		public ApplicantAggregateBuilder accountBalance(int balance) {
			this.accountBalance = new AccountBalance(new Money(balance));
			return this;
		}

		public ApplicantAggregate build() {
			if(this.accountBalance == null) {
				this.accountBalance = new AccountBalance(new Money());
			}
			return new ApplicantAggregate(this);
		}
	}
}
