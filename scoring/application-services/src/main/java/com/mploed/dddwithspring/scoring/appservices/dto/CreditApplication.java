package com.mploed.dddwithspring.scoring.appservices.dto;

import com.mploed.dddwithspring.scoring.ApplicationNumber;
import com.mploed.dddwithspring.scoring.Money;

public class CreditApplication {
	private ApplicationNumber applicationNumber;
	private Applicant applicant;
	private FinancialSituation financialSituation;

	public ApplicationNumber getApplicationNumber() {
		return applicationNumber;
	}

	public FinancialSituation getFinancialSituation() {
		return financialSituation;
	}

	public Applicant getApplicant() {
		return applicant;
	}

	private CreditApplication(CreditApplication.CreditApplicationBuilder builder) {
		this.applicationNumber = builder.applicationNumber;
		this.applicant = builder.applicant;
		this.financialSituation = builder.financialSituation;
	}

	public static class CreditApplicationBuilder {
		private final ApplicationNumber applicationNumber;
		private Applicant applicant;
		private FinancialSituation financialSituation;

		public CreditApplicationBuilder(ApplicationNumber applicationNumber) {
			this.applicationNumber = applicationNumber;
		}

		public CreditApplication.CreditApplicationBuilder withFinancialSituation(Money costOfLiving,
		                                                                         Money furtherIncome,
		                                                                         Money rent,
		                                                                         Money salary) {
			this.financialSituation = new FinancialSituation(costOfLiving, furtherIncome, rent, salary);
			return this;

		}
		public CreditApplication.CreditApplicationBuilder withApplicant(String firstName,
		                                                                      String lastName,
		                                                                      String street,
		                                                                      String postCode,
		                                                                      String city) {
			this.applicant = new Applicant(firstName, lastName, street, postCode, city);
			return this;
		}


		public CreditApplication build() {
			return new CreditApplication(this);
		}
	}
}
