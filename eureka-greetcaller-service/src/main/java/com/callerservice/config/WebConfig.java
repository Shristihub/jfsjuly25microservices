package com.callerservice.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.blocking.client.BlockingLoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

@Configuration
public class WebConfig {

	@Bean
	@LoadBalanced // behaves like a loadbalanced client
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
	@Bean
	@LoadBalanced
	RestClient.Builder restClientBuilder() {
		return RestClient.builder();
				
	}
}
