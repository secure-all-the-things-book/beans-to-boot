package com.example.beans_to_boot.environment;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.util.Assert;

@Configuration
@ComponentScan
@PropertySource("classpath:application.properties")
@EnableTransactionManagement
@Import(DogBeanRegistrar.class)
class DogConfiguration {

    @Bean
    DriverManagerDataSource driverManagerDataSource(
            Environment environment,
            @Value("${spring.datasource.url}") String urlValue) {
        var url = environment.getProperty("spring.datasource.url");
        var username = environment.getProperty("spring.datasource.username");
        var pw = environment.getProperty("spring.datasource.password");
        Assert.notNull(url, "url must be non-null");
        Assert.notNull(username, "username must be non-null");
        Assert.notNull(pw, "password must be non-null");
        Assert.state(url.equals(urlValue), "url must be set and the same");
        return new DriverManagerDataSource(url, username, pw);
    }

}
