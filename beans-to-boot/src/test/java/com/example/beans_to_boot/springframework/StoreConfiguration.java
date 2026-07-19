package com.example.beans_to_boot.springframework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Clock;

@Configuration
class StoreConfiguration {

	@Bean
    StoreService storeService(Clock clock) {
		return new StoreService(clock);
	}

	@Bean
	Clock clock() {
		return Clock.systemDefaultZone();
	}

}
