package com.example.beans_to_boot.boot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;

@Controller
@ResponseBody
class DogController {

	private final DogRepository repository;

	DogController(DogRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/dogs")
	Collection<Dog> dogs() {
		return this.repository.findAll();
	}

}
