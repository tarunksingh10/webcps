package com.webcps.webcps;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan
@PropertySource(value = {"classpath:/application.properties",
        "file:/D:\\codebase\\files\\datasource.properties"},
        ignoreResourceNotFound = true)
public class PersistenceJPAConfig {
	
	


    @Bean
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSource dataSource() {
        return new DriverManagerDataSource();
    }
}