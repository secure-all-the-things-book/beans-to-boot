package com.example.beans_to_boot.raw;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

class DefaultDogRepository implements DogRepository {

	private final DataSource db;

	DefaultDogRepository() {
		// <.>
		this.db = new DriverManagerDataSource("jdbc:postgresql://localhost/mydatabase", "myuser", "secret");
	}

	@Override
	public Collection<Dog> findAll() {
		// <.>
		try (var connection = this.db.getConnection(); //
				var ps = connection.prepareStatement("select * from dog") //
		) {
			var list = new ArrayList<Dog>();
			try (var rs = ps.executeQuery()) {
				while (rs.next())
					list.add(new Dog(rs.getInt("id"), rs.getString("name"), rs.getString("description")));
			}
			return list;
		} //
		catch (SQLException throwable) {
			throw new RuntimeException(throwable);
		}
	}

}
