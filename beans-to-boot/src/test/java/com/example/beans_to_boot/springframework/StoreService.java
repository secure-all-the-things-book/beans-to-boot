package com.example.beans_to_boot.springframework;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Clock;
import java.time.LocalTime;

@Service
@Transactional
class StoreService {

	private final Clock clock;

	StoreService(Clock clock) {
		this.clock = clock;
	}

	boolean isOpen() {
		var hour = LocalTime.now(this.clock).getHour();
		return hour >= 9 && hour < 17;
	}

}
