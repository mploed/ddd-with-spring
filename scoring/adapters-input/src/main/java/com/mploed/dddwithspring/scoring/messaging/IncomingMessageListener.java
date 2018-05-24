package com.mploed.dddwithspring.scoring.messaging;

import com.mploed.dddwithspring.scoring.ScoringApplicationService;
import com.mploed.dddwithspring.scoring.incoming.AgencyResultArrivedEvent;
import com.mploed.dddwithspring.scoring.incoming.ApplicationSubmittedEvent;
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
		scoringApplicationService.scoreApplication(applicationSubmittedEvent);

	}


}
