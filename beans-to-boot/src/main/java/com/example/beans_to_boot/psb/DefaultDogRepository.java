package com.example.beans_to_boot.psb;

import org.springframework.jdbc.core.simple.JdbcClient;

import java.util.Collection;

class DefaultDogRepository implements DogRepository {

    private final JdbcClient db;

    DefaultDogRepository(JdbcClient db) {
        this.db = db;
    }

    @Override
    public Collection<Dog> findAll() {
        return db // <.>
                .sql("select * from dog")//
                // <.>
                .query((rs, _) -> new Dog(//
                        rs.getInt("id"), //
                        rs.getString("name"),//
                        rs.getString("description"))//
                ) //
                .list();
    }

}
