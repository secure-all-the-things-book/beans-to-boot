package com.example.beans_to_boot.tx1;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Main {

	static void main(String[] args) {
		var db = new DriverManagerDataSource("jdbc:postgresql://localhost/mydatabase", "myuser", "secret");
		var jdbc = JdbcClient.create(db);
		var dogRepository = new DefaultDogRepository(jdbc);
		var dbPlatformTransactionManager = new DataSourceTransactionManager(db);
		var transactionalDogRepository = new TransactionalDogRepository(dbPlatformTransactionManager, dogRepository);
		test(transactionalDogRepository);
	}

	static void test(DogRepository repository) {
		repository.findAll().forEach(IO::println);
	}

}
