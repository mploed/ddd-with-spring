package com.mploed.dddwithspring.scoring.realEstateProperty;


import com.mploed.dddwithspring.scoring.ApplicationNumber;

import java.util.HashSet;
import java.util.Set;

public class RealEstatePropertyAggregate {


	public static class RealEstatePropertyBuilder {
		private final ApplicationNumber applicationNumber;

		private final Set<Loan> loans;

		public RealEstatePropertyBuilder(ApplicationNumber applicationNumber) {

			this.applicationNumber = applicationNumber;
			this.loans = new HashSet<Loan>();
		}

		public RealEstatePropertyBuilder withLoan(int fixedInterestRateInYears, int amount, int monthlyPayment) {
			this.loans.add(new Loan(fixedInterestRateInYears, amount, monthlyPayment));
			return this;
		}


	}
}