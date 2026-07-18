package com.example.beans_to_boot.boot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = StoreConfiguration.class)
class MockitoBeanTest {

	// <.>
	@MockitoBean(enforceOverride = true)
	Clock clock;

	// <.>
	@BeforeEach
	void before() throws Exception {
		var tenAm = Instant.parse("2026-07-17T10:00:00Z");
		Mockito.when(this.clock.instant()).thenReturn(tenAm);
		Mockito.when(this.clock.getZone()).thenReturn(ZoneId.of("Z"));
	}

	@Test
	void businessIsOpenAt10Am(@Autowired StoreService service) {
		Assertions.assertTrue(service.isOpen());
	}

}
