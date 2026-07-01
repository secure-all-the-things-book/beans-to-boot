package com.example.beans_to_boot.boot;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@Import(DogBeanRegistrar.class)
@SpringBootApplication
public class Main {

	static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	@Bean
	ApplicationRunner testRunner(DogRepository repository) {
		return _ -> repository.findAll().forEach(IO::println);
	}

}
