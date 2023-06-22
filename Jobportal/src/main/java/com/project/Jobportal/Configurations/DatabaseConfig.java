package com.project.Jobportal.Configurations;

import com.mchange.v2.c3p0.DriverManagerDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {

    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/job_portal?useSSL=false&allowPublicKeyRetrieval=true");
        dataSource.setUser("root");
        dataSource.setPassword("root");
        System.err.println("Logging: dataSource()");
        return dataSource;
    }
}