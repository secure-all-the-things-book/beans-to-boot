package com.example.beans_to_boot.springframework;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.env.Environment;
import org.springframework.util.Assert;

class Announcer implements InitializingBean {

	private final String name;

	private final Environment environment;

	Announcer(Environment environment, String name) {
		this.name = name;
		this.environment = environment;
		Assert.notNull(name, "Name must not be null");
		Assert.notNull(environment, "Environment must not be null");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		IO.println("Hello, " + name + "!");
	}

	String name() {
		return name;
	}

}
