package com.project.Jobportal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class JobportalApplication extends SpringBootServletInitializer
{

	public static void main(String[] args) {
		System.out.println("Main method executed.");
		SpringApplication.run(JobportalApplication.class, args);
	}

}
