package com.allclearwas.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class WebSecurityConfig {

	private final FilterRegisterConfig filterRegisterConfig;
	private final AuthenticationEntryPoint jwtAuthenticationEntryPoint;
	private final AccessDeniedHandler jwtAccessDeniedHandler;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.securityMatcher("/api/**")
			.csrf(AbstractHttpConfigurer::disable)
			.cors(Customizer.withDefaults())
			.authorizeHttpRequests(request -> {
				request.requestMatchers("/api-docs/**", "/v3/api-docs/**", "/swagger-ui/**", "/swagger").permitAll();
				request.requestMatchers("/api/v1/auth/**")
					.anonymous();
				request.requestMatchers("/api/v1/sign-out").authenticated();
				request.anyRequest().permitAll();
			})
			.with(filterRegisterConfig, Customizer.withDefaults())
			.exceptionHandling(handler -> {
				handler.authenticationEntryPoint(jwtAuthenticationEntryPoint);
				handler.accessDeniedHandler(jwtAccessDeniedHandler);
			});
		return http.build();
	}
}
