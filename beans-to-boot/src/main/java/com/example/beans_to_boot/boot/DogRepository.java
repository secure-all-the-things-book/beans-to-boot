package com.example.beans_to_boot.boot;

import org.springframework.data.repository.ListCrudRepository;

import java.util.Collection;

interface DogRepository extends ListCrudRepository<Dog, Integer> {

	Collection<Dog> findByName(String name);

}