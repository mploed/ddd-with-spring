package com.mploed.dddwithspring.scoring.messaging;

import com.mploed.dddwithspring.scoring.ApplicationNumber;
import com.mploed.dddwithspring.scoring.ScoringApplicationService;
import com.mploed.dddwithspring.scoring.events.ScoringPerformed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class SpringEventListener implements ApplicationListener<ScoringPerformed> {

	private ScoringApplicationService scoringApplicationService;

	@Autowired
	public SpringEventListener(ScoringApplicationService scoringApplicationService) {
		this.scoringApplicationService = scoringApplicationService;
	}

	@Override
	public void onApplicationEvent(ScoringPerformed event) {
		scoringApplicationService.performFinalScoring(new ApplicationNumber(event.getApplicationNumber()));
	}
}
