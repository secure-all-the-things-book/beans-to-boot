package com.example.beans_to_boot.pp;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.transaction.support.TransactionTemplate;

class TxBeanFactoryPostProcessor implements BeanPostProcessor {

    private final BeanFactory beanFactory;

    TxBeanFactoryPostProcessor(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    @Override
    public @Nullable Object postProcessAfterInitialization(
            Object bean, String beanName) throws BeansException {
        if (bean instanceof Tx tx) {
            IO.println("making a transactional proxy for [" + tx.getClass()
                    .getName() + "] with bean name [" + beanName + "]");
            var tt = beanFactory.getBean(TransactionTemplate.class);
            return Transactions.createProxy(tt, tx);
        }
        return bean;
    }
}
