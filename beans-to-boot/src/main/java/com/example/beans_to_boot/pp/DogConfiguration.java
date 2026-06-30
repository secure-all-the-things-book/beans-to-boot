package com.example.beans_to_boot.pp;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;

@Configuration
class DogConfiguration {

    @Bean
    static TxBeanFactoryPostProcessor txBeanFactoryPostProcessor(BeanFactory beanFactory) {
        return new TxBeanFactoryPostProcessor(beanFactory);
    }

    @Bean
    Listener listener() {
        return new Listener();
    }

    @Bean
    TransactionTemplate transactionTemplate(PlatformTransactionManager platformTransactionManager) {
        return new TransactionTemplate(platformTransactionManager);
    }

    @Bean
    DriverManagerDataSource driverManagerDataSource() {
        return new DriverManagerDataSource("jdbc:postgresql://localhost/mydatabase", "myuser", "secret");
    }

    @Bean
    JdbcClient jdbcClient(DataSource dataSource) {
        return JdbcClient.create(dataSource);
    }

    @Bean
    DogRepository dogRepository(TransactionTemplate tt, JdbcClient jdbcClient) {
        return new DogRepository(jdbcClient);
    }

    @Bean
    DataSourceTransactionManager dataSourceTransactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
