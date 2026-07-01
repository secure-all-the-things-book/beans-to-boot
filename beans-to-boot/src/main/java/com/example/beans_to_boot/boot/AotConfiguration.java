package com.example.beans_to_boot.boot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.core.dialect.JdbcPostgresDialect;

@Configuration
class AotConfiguration {

	@Bean
	JdbcPostgresDialect jdbcPostgresDialect() {
		return JdbcPostgresDialect.INSTANCE;
	}

}
