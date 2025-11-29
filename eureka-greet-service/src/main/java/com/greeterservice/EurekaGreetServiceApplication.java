package com.greeterservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EurekaGreetServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaGreetServiceApplication.class, args);
	}

}
