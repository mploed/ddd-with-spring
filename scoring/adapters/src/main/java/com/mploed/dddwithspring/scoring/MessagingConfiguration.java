package com.mploed.dddwithspring.scoring;

import com.mploed.dddwithspring.scoring.messaging.ApplicationProcessChannels;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBinding(ApplicationProcessChannels.class)
public class MessagingConfiguration {
}
