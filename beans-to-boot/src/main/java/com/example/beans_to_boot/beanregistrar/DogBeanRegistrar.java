package com.example.beans_to_boot.beanregistrar;

import org.springframework.beans.factory.BeanRegistrar;
import org.springframework.beans.factory.BeanRegistry;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;

class DogBeanRegistrar implements BeanRegistrar {

    @Override
    public void register(BeanRegistry registry, Environment env) {
        registry.registerBean(Listener.class);
        registry.registerBean(MyBeanFactoryPostProcessor.class);
        registry.registerBean(TransactionTemplate.class,
                a -> a.supplier(ctx -> new TransactionTemplate(ctx.bean(DataSourceTransactionManager.class))));
        registry.registerBean(JdbcClient.class, a -> a
                .supplier(ctx -> JdbcClient.create(ctx.bean(DataSource.class))));
        registry.registerBean(DataSourceTransactionManager.class, a -> a
                .supplier(supplierContext -> new DataSourceTransactionManager(supplierContext.bean(DataSource.class))));
    }
}
