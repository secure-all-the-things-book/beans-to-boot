package com.example.beans_to_boot.boot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

// <.>
@ExtendWith(SpringExtension.class)
// <.>
@ContextConfiguration(classes = SpringTest.SpringTestConfiguration.class)
class SpringTest {

	final static String NAME = "Spring fans";

	@Test
	void test(@Autowired Announcer announcer) {
		Assertions.assertEquals(NAME, announcer.name());
	}

	// <.>
	@Configuration
	static class SpringTestConfiguration {

		@Bean
		Announcer announcer(Environment env) {
			return new Announcer(env, NAME);
		}

	}

}
