package com.example.beans_to_boot.autoconfigure;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;

@AutoConfiguration // <.>
@ConditionalOnRandomness // <.>
class SillyAutoConfigurationExample {

	@Bean
	// <.>
	@ConditionalOnProperty(value = "my.config", matchIfMissing = true, havingValue = "bar")
	ApplicationRunner myConditionalBean() {
		return _ -> IO.println("randomly initialized bean");
	}

}
