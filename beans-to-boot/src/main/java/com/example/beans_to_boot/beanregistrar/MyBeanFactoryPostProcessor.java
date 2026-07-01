package com.example.beans_to_boot.beanregistrar;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

		for (var beanName : beanFactory.getBeanDefinitionNames()) {
			var beanDefinition = beanFactory.getBeanDefinition(beanName);
			var clzz = beanFactory.getType(beanName);
			IO.println("got the bean definition for [" + clzz.getName() + "] with bean name [" + beanName + "]: "
					+ beanDefinition.getDescription());
		}

	}

}
