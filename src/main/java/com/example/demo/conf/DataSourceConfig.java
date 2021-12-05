package com.example.demo.conf;

import com.zaxxer.hikari.HikariDataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

/**
 * 功能描述
 *
 * @author KEVIN
 * @since 2021-12-05
 */
@Configuration
public class DataSourceConfig {
    @Bean(name = "dataSource")
    public DataSource dataSource(Environment environment) {
        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl(environment.getProperty("spring.datasource.url"));
        ds.setUsername(environment.getProperty("spring.datasource.username"));
        ds.setPassword(environment.getProperty("spring.datasource.password"));
        ds.setDriverClassName(environment.getProperty("spring.datasource.driver-class-name"));
        return ds;
    }
}
