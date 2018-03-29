package com.mploed.dddwithspring.scoring.messaging;

import com.mploed.dddwithspring.scoring.ScoringApplicationService;
import com.mploed.dddwithspring.scoring.events.incoming.AgencyResultArrivedEvent;
import com.mploed.dddwithspring.scoring.events.incoming.ApplicantAddedEvent;
import com.mploed.dddwithspring.scoring.events.incoming.ApplicationSubmittedEvent;
import com.mploed.dddwithspring.scoring.events.incoming.FinancialSituationEnteredEvent;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class IncomingMessageListener {
	private ScoringApplicationService scoringApplicationService;

	public IncomingMessageListener(ScoringApplicationService scoringApplicationService) {
		this.scoringApplicationService = scoringApplicationService;
	}

	@StreamListener(ApplicationProcessChannels.AGENCY_RESULT_ARRIVED)
	public void receiveAgencyResult(@Payload AgencyResultArrivedEvent agencyResultArrivedEvent) {
		scoringApplicationService.scoreAgencyResult(agencyResultArrivedEvent);
	}

	@StreamListener(ApplicationProcessChannels.APPLICANT_ADDED)
	public void receiveApplicant(@Payload ApplicantAddedEvent applicantAddedEvent) {
		scoringApplicationService.scoreApplicant(applicantAddedEvent);
	}

	@StreamListener(ApplicationProcessChannels.FINANCIAL_SITUATION_ENTERED)
	public void receiveFinancialSituation(@Payload FinancialSituationEnteredEvent financialSituationEnteredEvent) {

	}

	@StreamListener(ApplicationProcessChannels.APPLICATION_SUBMITTED)
	public void receiveApplicationSubmission(@Payload ApplicationSubmittedEvent applicationSubmittedEvent) {

	}


}
