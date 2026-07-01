package com.example.beans_to_boot.environment;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.net.URI;
import java.util.Objects;

@Configuration
@ComponentScan
// <.>
@PropertySource("classpath:application.properties")
@EnableTransactionManagement
@Import(DogBeanRegistrar.class)
class DogConfiguration {

	@Bean
	DriverManagerDataSource driverManagerDataSource(Environment environment,
			// <.>
			@Value("${spring.datasource.username}") String usernameValue) {
		IO.println("configuring the DataSource username: [" + usernameValue + "]");
		// <.>
		var username = environment.getProperty("spring.datasource.username");
		// <.>
		var url = environment.getProperty("spring.datasource.url", URI.class);
		var pw = environment.getProperty("spring.datasource.password");
		return new DriverManagerDataSource(Objects.requireNonNull(url).toASCIIString(), username, pw);
	}

}
