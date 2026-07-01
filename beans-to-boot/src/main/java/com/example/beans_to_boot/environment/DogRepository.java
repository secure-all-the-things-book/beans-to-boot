package com.example.beans_to_boot.environment;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Repository
@Transactional
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

	@Override
	public void destroy() throws Exception {
		IO.println("destroy");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		IO.println("afterPropertiesSet");
	}

}
