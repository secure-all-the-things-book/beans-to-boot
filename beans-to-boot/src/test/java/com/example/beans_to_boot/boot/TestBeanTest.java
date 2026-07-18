package com.example.beans_to_boot.boot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.bean.override.convention.TestBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneOffset;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = StoreConfiguration.class)
class TestBeanTest {

	// <.>
	@TestBean(enforceOverride = true)
	Clock clock;

	// <.>
	static Clock clock() throws Exception {
		var tenAm = Instant.parse("2026-07-17T10:00:00Z");
		return Clock.fixed(tenAm, ZoneOffset.UTC);
	}

	@Test
	void businessIsOpenAt10Am(@Autowired StoreService service) {
		Assertions.assertTrue(service.isOpen());
	}

}
