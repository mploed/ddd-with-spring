package com.mploed.dddwithspring.creditagency.messaging;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface CreditAgencyChannels {
	String APPLICATION_SUBMITTED = "applicationSubmittedIn";

	@Input
	SubscribableChannel applicationSubmittedIn();
}
