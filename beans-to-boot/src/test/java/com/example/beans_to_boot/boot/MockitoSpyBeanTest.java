package com.example.beans_to_boot.boot;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.bean.override.mockito.MockitoSpyBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = StoreConfiguration.class)
class MockitoSpyBeanTest {

	@MockitoSpyBean
	private StoreService storeService;

	@Test
	void callsTheRealMethodByDefault() {
		// the real isOpen() actually executes against the real Clock
		// <.>
		var open = storeService.isOpen();

		// <.>
		// ...but it's a spy, so the invocation is still recorded
		verify(storeService).isOpen();
		assertThat(open).isIn(true, false);
	}

	@Test
	void canStubASingleMethodWhenYouWantTo() {
		// <.>
		given(storeService.isOpen()).willReturn(true); // override just this call

		// <.>
		assertThat(storeService.isOpen()).isTrue();
	}

}
