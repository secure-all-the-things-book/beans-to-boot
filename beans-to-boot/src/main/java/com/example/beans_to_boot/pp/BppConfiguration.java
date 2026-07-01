package com.example.beans_to_boot.pp;

import jdk.jfr.Description;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class BppConfiguration {

	@Bean
	@Description("A simple demo that has a description")
	InitializingBean simpleDemoThatHasADescription() {
		return () -> IO.println("a demo with a description ");
	}

	@Bean
	static MyBeanFactoryPostProcessor myBeanFactoryPostProcessor() {
		return new MyBeanFactoryPostProcessor();
	}

}
