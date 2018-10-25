package com.mploed.dddwithspring.scoring.financialSituation;

import com.mploed.dddwithspring.scoring.ApplicationNumber;
import com.mploed.dddwithspring.scoring.Money;
import com.mploed.dddwithspring.scoring.microarchitecture.Aggregate;
import com.mploed.dddwithspring.scoring.microarchitecture.AggregateBuilder;

@Aggregate
public class FinancialSituationAggregate {
	FinancialSituationRootEntity rootEntity;

	private FinancialSituationAggregate(FinancialSituationBuilder builder) {
		Incomings incomings = new Incomings(builder.salary, builder.otherIncome);
		Outgoings outgoings = new Outgoings(builder.rent, builder.costOfLiving);
		this.rootEntity = new FinancialSituationRootEntity(builder.applicationNumber, incomings, outgoings);
	}

	public int calculateScoringPoints() {
		Money monthlyBalance = rootEntity.sum();
		if(monthlyBalance.isGreaterThan(new Money(2000))) {
			return 20;
		} else if(monthlyBalance.isGreaterThan(new Money(1000))) {
			return 15;
		} else if(monthlyBalance.isGreaterThan(new Money(750))) {
			return 10;
		} else if(monthlyBalance.isGreaterThan(new Money(500))) {
			return 5;
		} else if (monthlyBalance.isGreaterThan(new Money(250))) {
			return 2;
		} else if( monthlyBalance.isGreaterThan(new Money(0))) {
			return 0;
		} else {
			return -20;
		}
	}

	@AggregateBuilder
	public static class FinancialSituationBuilder {
		private final ApplicationNumber applicationNumber;
		private Money rent;
		private Money costOfLiving;
		private Money salary;
		private Money otherIncome;

		public FinancialSituationBuilder(ApplicationNumber applicationNumber) {
			this.applicationNumber = applicationNumber;
		}

		public FinancialSituationBuilder rent(int rent) {
			this.rent = new Money(rent);
			return this;
		}

		public FinancialSituationBuilder costOfLiving(int costOfLiving) {
			this.costOfLiving = new Money(costOfLiving);
			return this;
		}

		public FinancialSituationBuilder salary(int salary) {
			this.salary = new Money(salary);
			return this;
		}

		public FinancialSituationBuilder otherIncome(int otherIncome) {
			this.otherIncome = new Money(otherIncome);
			return this;
		}

		public FinancialSituationAggregate build() {
			return new FinancialSituationAggregate(this);
		}
	}
}
