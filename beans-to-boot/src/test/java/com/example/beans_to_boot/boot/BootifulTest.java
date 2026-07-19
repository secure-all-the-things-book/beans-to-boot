package com.example.beans_to_boot.boot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BootifulTest {

	// <.>
	@Test
	void dogs(@Autowired DogRepository repository) {
		Assertions.assertEquals(3, repository.findAll().size());
	}

}
