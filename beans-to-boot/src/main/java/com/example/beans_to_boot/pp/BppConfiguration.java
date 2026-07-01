package com.example.beans_to_boot.pp;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;

@Configuration
class BppConfiguration {

	@Bean
	static MyBeanFactoryPostProcessor myBeanFactoryPostProcessor() {
		return new MyBeanFactoryPostProcessor();
	}

	@Bean
	@Description("A simple demo that has a description")
	InitializingBean simpleDemoThatHasADescription() {
		return () -> IO.println("a demo with a description ");
	}

}
