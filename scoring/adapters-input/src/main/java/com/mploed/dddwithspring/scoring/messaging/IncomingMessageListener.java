package com.mploed.dddwithspring.scoring.messaging;

import com.mploed.dddwithspring.scoring.ApplicationNumber;
import com.mploed.dddwithspring.scoring.Money;
import com.mploed.dddwithspring.scoring.appservices.ScoringApplicationService;
import com.mploed.dddwithspring.scoring.appservices.dto.CreditApplication;
import com.mploed.dddwithspring.scoring.appservices.dto.FinancialSituation;
import com.mploed.dddwithspring.scoring.incoming.ApplicationSubmittedEvent;
import com.mploed.dddwithspring.scoring.incoming.applicant.Applicant;
import com.mploed.dddwithspring.scoring.incoming.household.EarningCapacity;
import com.mploed.dddwithspring.scoring.incoming.household.MonthlyExpenses;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class IncomingMessageListener {
	private ScoringApplicationService scoringApplicationService;

	public IncomingMessageListener(ScoringApplicationService scoringApplicationService) {
		this.scoringApplicationService = scoringApplicationService;
	}

	@StreamListener(ApplicationProcessChannels.APPLICATION_SUBMITTED)
	public void receiveApplicationSubmission(@Payload ApplicationSubmittedEvent applicationSubmittedEvent) {
		Applicant firstApplicant = applicationSubmittedEvent.getFirstApplicant();
		MonthlyExpenses monthlyExpenses = applicationSubmittedEvent.getHousehold().getMonthlyExpenses();
		EarningCapacity earningCapacity = applicationSubmittedEvent.getHousehold().getEarningCapacity();
		CreditApplication creditApplication = new CreditApplication.CreditApplicationBuilder(new ApplicationNumber(applicationSubmittedEvent.getApplicationNumber()))
				.withApplicant(firstApplicant.getFirstName(),
								firstApplicant.getLastName(),
								firstApplicant.getAddress().getStreet(),
								firstApplicant.getAddress().getPostCode(),
								firstApplicant.getAddress().getCity())
				.withFinancialSituation(new Money(monthlyExpenses.getCostOfLiving()),
										new Money(earningCapacity.getFurtherIncome()),
										new Money(monthlyExpenses.getRent()),
										new Money(earningCapacity.getSalaryFirstApplicant()))
				.build();
		scoringApplicationService.scoreApplication(creditApplication);

	}


}
