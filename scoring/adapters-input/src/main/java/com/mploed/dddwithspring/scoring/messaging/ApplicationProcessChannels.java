package com.mploed.dddwithspring.scoring.messaging;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface ApplicationProcessChannels {
	String APPLICATION_SUBMITTED = "applicationSubmittedIn";

	@Input
	SubscribableChannel applicationSubmittedIn();
}
