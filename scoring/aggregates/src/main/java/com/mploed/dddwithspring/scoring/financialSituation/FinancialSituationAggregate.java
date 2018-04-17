package com.mploed.dddwithspring.scoring.financialSituation;

import com.mploed.dddwithspring.scoring.ApplicationNumber;
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
		int monthlyBalance = rootEntity.sum();
		if(monthlyBalance > 2000) {
			return 20;
		} else if(monthlyBalance > 1000) {
			return 15;
		} else if(monthlyBalance > 750) {
			return 10;
		} else if(monthlyBalance > 500) {
			return 5;
		} else if (monthlyBalance > 250) {
			return 2;
		} else if( monthlyBalance > 0) {
			return 0;
		} else {
			return -20;
		}
	}

	@AggregateBuilder
	public static class FinancialSituationBuilder {
		private final ApplicationNumber applicationNumber;
		private int rent;
		private int costOfLiving;
		private int salary;
		private int otherIncome;

		public FinancialSituationBuilder(ApplicationNumber applicationNumber) {
			this.applicationNumber = applicationNumber;
		}

		public FinancialSituationBuilder rent(int rent) {
			this.rent = rent;
			return this;
		}

		public FinancialSituationBuilder costOfLiving(int costOfLiving) {
			this.costOfLiving = costOfLiving;
			return this;
		}

		public FinancialSituationBuilder salary(int salary) {
			this.salary = salary;
			return this;
		}

		public FinancialSituationBuilder otherIncome(int otherIncome) {
			this.otherIncome = otherIncome;
			return this;
		}

		public FinancialSituationAggregate build() {
			return new FinancialSituationAggregate(this);
		}
	}
}
