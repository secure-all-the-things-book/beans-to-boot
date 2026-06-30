package com.example.beans_to_boot.cglibproxy;

import org.springframework.jdbc.core.simple.JdbcClient;

import java.util.Collection;

class DogRepository {

	private final JdbcClient db;

	DogRepository(JdbcClient db) {
		this.db = db;
	}

	public Collection<Dog> findAll() {
		return db.sql("select * from dog")
			.query((rs, i) -> new Dog(rs.getInt("id"), rs.getString("name"), rs.getString("description")))
			.list();
	}

}
