package com.revature.SpringBootDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.Entity;

@EntityScan("com.revature.SpringBootDemo.models")
@EnableTransactionManagement
@EnableJpaRepositories("com.revature.SpringBootDemo.repos")
@EnableJpaAuditing
@SpringBootApplication
public class SpringBootDemoApplication {

	/***
	 *Because this is a Spring Boot Application we do not need the @ComponentScan
	 * to scan all the packages
	 * We only need to tell spring where to find the JPA repositories
	 */




	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoApplication.class, args);
	}

}
