package com.mploed.dddwithspring.scoring;

import com.mploed.dddwithspring.scoring.messaging.ApplicationProcessChannels;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableBinding(ApplicationProcessChannels.class)
@EnableScheduling
public class InputAdaptersConfiguration {
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
