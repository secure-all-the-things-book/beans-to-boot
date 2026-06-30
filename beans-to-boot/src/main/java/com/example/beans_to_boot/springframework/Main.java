package com.example.beans_to_boot.springframework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        var applicationContext = new AnnotationConfigApplicationContext(DogConfiguration.class);
        var dogRepository = applicationContext.getBean(DogRepository.class);
        test(dogRepository);
    }

    static void test(DogRepository repository) {
        repository.findAll().forEach(IO::println);
    }

}

