package com.example.beans_to_boot.boot;

import org.jspecify.annotations.Nullable;
import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportRuntimeHints;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.nio.charset.Charset;

@Configuration
// <.>
@ImportRuntimeHints(AotConfiguration.Hints.class)
class AotConfiguration {

	// <.>
	private static final Resource MESSAGE = new ClassPathResource("/message");

	static class Hints implements RuntimeHintsRegistrar {

		@Override
		public void registerHints(RuntimeHints hints, @Nullable ClassLoader classLoader) {
			// <.>
			hints.resources().registerResource(MESSAGE);
		}

	}

	// <.>
	@Bean
	ApplicationRunner messageLoader() {
		return _ -> IO.println(MESSAGE.getContentAsString(Charset.defaultCharset()));
	}

}
