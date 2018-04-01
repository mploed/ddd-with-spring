package com.mploed.dddwithspring.scoring.messaging;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface ApplicationProcessChannels {
	String AGENCY_RESULT_ARRIVED = "agencyResultArrivedIn";
	String APPLICANT_ADDED = "applicantAddedIn";
	String APPLICATION_SUBMITTED = "applicationSubmittedIn";
	String FINANCIAL_SITUATION_ENTERED = "financialSituationEnteredIn";

	@Input
	SubscribableChannel agencyResultArrivedIn();

	@Input
	SubscribableChannel applicantAddedIn();

	@Input
	SubscribableChannel applicationSubmittedIn();

	@Input
	SubscribableChannel financialSituationEnteredIn();

}
