package com.example.beans_to_boot.jdkproxy;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.support.TransactionTemplate;

public class Main {

	static void main(String[] args) {
		var db = new DriverManagerDataSource("jdbc:postgresql://localhost/mydatabase", "myuser", "secret");
		var jdbc = JdbcClient.create(db);
		var dogRepository = new DefaultDogRepository(jdbc);
		var dbPlatformTransactionManager = new DataSourceTransactionManager(db);
		var transactionTemplate = new TransactionTemplate(dbPlatformTransactionManager);
		var transactionalDogRepository = (DogRepository) Transactions.createProxy(transactionTemplate, dogRepository);
		test(transactionalDogRepository);
	}

	static void test(DogRepository repository) {
		repository.findAll().forEach(IO::println);
	}

}
