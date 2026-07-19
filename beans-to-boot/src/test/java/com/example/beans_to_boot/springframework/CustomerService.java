package com.example.beans_to_boot.springframework;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;

@Service
@Transactional
class CustomerService {

	private final DataSource dataSource;

	CustomerService(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	DataSource dataSource() {
		return this.dataSource;
	}

}
