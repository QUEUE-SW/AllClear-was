package com.allclearwas.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.allclearwas.common.security.filter.JwtAuthenticationFilter;
import com.allclearwas.common.security.filter.JwtExceptionFilter;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class FilterRegisterConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

	private final JwtAuthenticationFilter jwtAuthenticationFilter;
	private final JwtExceptionFilter jwtExceptionFilter;

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.addFilterBefore(jwtAuthenticationFilter, BasicAuthenticationFilter.class);
		http.addFilterBefore(jwtExceptionFilter, JwtAuthenticationFilter.class);
	}
}
