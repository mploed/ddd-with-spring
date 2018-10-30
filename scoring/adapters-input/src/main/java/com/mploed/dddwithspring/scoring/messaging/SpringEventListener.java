package com.mploed.dddwithspring.scoring.messaging;

import com.mploed.dddwithspring.scoring.ApplicationNumber;
import com.mploed.dddwithspring.scoring.appservices.ScoringApplicationService;
import com.mploed.dddwithspring.scoring.appservices.internalevents.PartOfScoringPerformed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class SpringEventListener implements ApplicationListener<PartOfScoringPerformed> {

	private ScoringApplicationService scoringApplicationService;

	@Autowired
	public SpringEventListener(ScoringApplicationService scoringApplicationService) {
		this.scoringApplicationService = scoringApplicationService;
	}

	@Override
	public void onApplicationEvent(PartOfScoringPerformed event) {
		scoringApplicationService.performFinalScoring(event.getApplicationNumber());
	}
}
