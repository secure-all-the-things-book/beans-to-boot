package com.example.beans_to_boot.boot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jdbc.test.autoconfigure.DataJdbcTest;
import org.springframework.context.annotation.Import;

@DataJdbcTest
class DataJdbcTestTest {

	@Test
	void dogs(@Autowired DogRepository repository) {
		Assertions.assertEquals(3, repository.findAll().size());
	}

}
