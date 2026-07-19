package com.example.beans_to_boot.springframework;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.client.RestTestClient;

class SimpleClientTest {

	private final RestTestClient client = RestTestClient.bindToController(new SimpleController()).build();

	@Test
	void greetings() {
		this.client.get()
			.uri("/greetings?name=Josh")
			.accept(MediaType.APPLICATION_JSON)
			.exchange()
			.expectStatus()
			.isOk()
			.expectBody()
			.jsonPath("$.greeting")
			.isEqualTo("Hello, Josh!");
	}

}
