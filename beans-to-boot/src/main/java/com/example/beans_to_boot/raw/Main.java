package com.example.beans_to_boot.raw;

public class Main {

	public static void main(String[] args) throws Exception {
		var dogRepository = new DefaultDogRepository();
		test(dogRepository);
	}

	static void test(DogRepository repository) {
		repository.findAll().forEach(IO::println);
	}

}
