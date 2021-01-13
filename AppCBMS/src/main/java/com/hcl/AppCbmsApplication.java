package com.hcl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableCircuitBreaker
@ComponentScan(basePackages="com.hcl")
public class AppCbmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppCbmsApplication.class, args);
	}

}
