package com.example.beans_to_boot.springframework;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

class SimpleControllerTest {

	// <.>
	private final MockMvc mockMvc = MockMvcBuilders.standaloneSetup(new SimpleController()).build();

	@Test
	void greetings() throws Exception {
		this.mockMvc
			.perform(MockMvcRequestBuilders.get("/greetings").param("name", "Josh").accept(MediaType.APPLICATION_JSON))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.jsonPath("$.greeting").value("Hello, Josh!"));
	}

}
