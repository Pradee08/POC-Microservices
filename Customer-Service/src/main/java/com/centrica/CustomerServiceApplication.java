package com.centrica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = { "com.centrica.controller" })
@ComponentScan(basePackages = { "com.centrica.service" })
@EntityScan(basePackages = { "com.centrica.model" })
@EnableJpaRepositories(basePackages = { "com.centrica.repository" })

@SpringBootApplication
public class CustomerServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}
}
