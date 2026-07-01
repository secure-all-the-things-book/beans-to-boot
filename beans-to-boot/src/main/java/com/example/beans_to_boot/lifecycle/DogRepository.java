package com.example.beans_to_boot.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.simple.JdbcClient;

import java.util.Collection;

class DogRepository implements InitializingBean, DisposableBean {

	private final JdbcClient db;

	DogRepository(JdbcClient db) {
		this.db = db;
	}

	public Collection<Dog> findAll() {
		return db.sql("select * from dog")
			.query((rs, i) -> new Dog(rs.getInt("id"), rs.getString("name"), rs.getString("description")))
			.list();
	}

	@PostConstruct
	void postInit() {
		IO.println("postInit");
	}

	@PreDestroy
	void preDestroy() {
		IO.println("preDestroy");
	}

	@Override
	public void destroy() throws Exception {
		IO.println("destroy");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		IO.println("afterPropertiesSet");
	}

}
