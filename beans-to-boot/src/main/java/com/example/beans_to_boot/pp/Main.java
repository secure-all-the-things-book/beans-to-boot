package com.example.beans_to_boot.pp;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        try (var applicationContext = new AnnotationConfigApplicationContext(DogConfiguration.class);) {
            applicationContext.registerShutdownHook();
            var dogRepository = applicationContext.getBean(DogRepository.class);
            test(dogRepository);
        }
    }

    static void test(DogRepository repository) {
        repository.findAll().forEach(IO::println);
    }

}

