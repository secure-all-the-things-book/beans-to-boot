package com.example.beans_to_boot.springframework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = DataSourceTest.SpringTestConfiguration.class)
class DataSourceTest {

	final static String NAME = "Spring fans";

	@MockitoBean
	DataSource dataSource;

	@BeforeEach
	void beforeEach() throws Exception {
		Assertions.assertNotNull(this.dataSource);
		Mockito.when(this.dataSource.getConnection()).thenReturn(Mockito.mock(java.sql.Connection.class));
	}

	@Test
	void test(@Autowired CustomerService customerService) throws Exception {
		Assertions.assertNotNull(customerService.dataSource());
		var connection = customerService.dataSource().getConnection();
		Assertions.assertNotNull(connection);
	}

	// <.>
	@Configuration
	static class SpringTestConfiguration {

		@Bean
		CustomerService customerService(DataSource dataSource) {
			return new CustomerService(dataSource);
		}

	}

}
