package com.allclearwas.config;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class SessionConfig {

	@Bean
	public Map<Long, Long> activeUsers() {
		return new ConcurrentHashMap<>();
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}


}
