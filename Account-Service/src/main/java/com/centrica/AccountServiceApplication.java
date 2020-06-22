package com.centrica;

import java.io.IOException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestClientException;

@ComponentScan(basePackages = { "com.centrica.controller" })
@ComponentScan(basePackages = { "com.centrica.feignservice" })
@ComponentScan(basePackages = { "com.centrica.service" })
@EntityScan(basePackages = { "com.centrica.model" })
@EnableJpaRepositories(basePackages = { "com.centrica.repository" })

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class AccountServiceApplication {
	public static void main(String[] args) throws RestClientException, IOException {
		SpringApplication.run(AccountServiceApplication.class, args);
	}
}
