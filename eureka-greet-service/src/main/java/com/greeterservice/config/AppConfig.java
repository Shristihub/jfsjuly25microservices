package com.greeterservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import com.greeterservice.service.DevMessengerService;
import com.greeterservice.service.IMessengerService;
import com.greeterservice.service.ProductionMessengerService;

@Configuration
public class AppConfig {

	@Bean
	@Profile("dev")
	IMessengerService greetMessenger() {
		return new DevMessengerService();
	}
	
	@Bean
	@Profile("prod")
	IMessengerService infoMessenger() {
		return new ProductionMessengerService();
	}
//	@Bean
//	IMessengerService infoMessenger1() {
//		return new ProductionMessengerService();
//	}
}





