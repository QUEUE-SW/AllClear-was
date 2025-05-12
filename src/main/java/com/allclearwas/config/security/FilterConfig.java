package com.allclearwas.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.allclearwas.common.jwt.AccessTokenProvider;
import com.allclearwas.common.security.filter.JwtAuthenticationFilter;
import com.allclearwas.common.security.filter.JwtExceptionFilter;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class FilterConfig {

	private final AccessTokenProvider accessTokenProvider;
	private final UserDetailsService userDetailsService;
	private final ObjectMapper objectMapper;


	@Bean
	public JwtAuthenticationFilter jwtAuthenticationFilter() {
		return new JwtAuthenticationFilter(
			accessTokenProvider,
			userDetailsService
		);
	}

	@Bean
	public JwtExceptionFilter jwtExceptionFilter() {
		return new JwtExceptionFilter(objectMapper);
	}
}
