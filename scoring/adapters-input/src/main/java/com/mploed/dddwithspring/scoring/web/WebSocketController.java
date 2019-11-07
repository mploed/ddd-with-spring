package com.mploed.dddwithspring.scoring.web;

import com.mploed.dddwithspring.scoring.appservices.internalevents.CreditAgencyResultArrived;
import com.mploed.dddwithspring.scoring.appservices.internalevents.CreditApplicationArrived;
import com.mploed.dddwithspring.scoring.appservices.internalevents.PartOfScoringPerformed;
import com.mploed.dddwithspring.scoring.appservices.internalevents.ScoringPerformed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {
	private SimpMessagingTemplate template;

	@Autowired
	public WebSocketController(SimpMessagingTemplate template) {
		this.template = template;
	}


	@EventListener
	public void greeting(PartOfScoringPerformed event) throws Exception {
		this.template.convertAndSend("/topic/greetings", new WebSocketMessage(event.getCluster() + " has been scored for Application Number: " + event.getApplicationNumber()));
	}

	@EventListener
	public void greeting(ScoringPerformed event) throws Exception {
		this.template.convertAndSend("/topic/greetings", new WebSocketMessage(event.getApplicationNumber() + " has been scored with " + event.getPoints() + " and final result " + event.getScoreColor()));
	}

	@EventListener
	public void greeting(CreditAgencyResultArrived event) throws Exception {
		this.template.convertAndSend("/topic/greetings", new WebSocketMessage("Credit Agency Result has arrived for Person" + event.getPersonId().toString()));
	}

	@EventListener
	public void greeting(CreditApplicationArrived event) throws Exception {
		this.template.convertAndSend("/topic/greetings", new WebSocketMessage("Credit Application has arrived with ID " + event.getApplicationNumber().toString()));
	}

}
