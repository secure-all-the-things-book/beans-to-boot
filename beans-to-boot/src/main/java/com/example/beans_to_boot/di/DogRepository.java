package com.example.beans_to_boot.di;

import java.util.Collection;

interface DogRepository {

	Collection<Dog> findAll();

}
