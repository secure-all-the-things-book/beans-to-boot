package com.example.beans_to_boot.beanregistrar;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan
@EnableTransactionManagement
@Import(DogBeanRegistrar.class)
class DogConfiguration {

	@Bean
	DriverManagerDataSource driverManagerDataSource() {
		return new DriverManagerDataSource("jdbc:postgresql://localhost/mydatabase", "myuser", "secret");
	}

}
