package com.example.beans_to_boot.tx2;

import org.springframework.transaction.support.TransactionTemplate;

import java.util.Collection;

class TransactionalDogRepository implements DogRepository {

	private final DogRepository target;

	private final TransactionTemplate txm;

	TransactionalDogRepository(TransactionTemplate txm, DogRepository target) {
		this.target = target;
		this.txm = txm;
	}

	@Override
	public Collection<Dog> findAll() {
		return this.txm.execute(_ -> target.findAll());
	}

}
