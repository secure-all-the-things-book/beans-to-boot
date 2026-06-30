package com.example.beans_to_boot.di;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Main {

	public static void main(String[] args) throws Exception {
		var db = new DriverManagerDataSource("jdbc:postgresql://localhost/mydatabase", "myuser", "secret");
		var dogRepository = new DefaultDogRepository(db);
		test(dogRepository);
	}

	static void test(DogRepository repository) {
		repository.findAll().forEach(IO::println);
	}

}
