package com.allclearwas.config;

import org.springframework.stereotype.Component;

import com.allclearwas.domains.session.implement.SessionManager;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class SessionInitializer {

	private final SessionManager sessionManager;

	@PostConstruct
	public void init() {
		sessionManager.reset();
		System.out.println("✅ Redis 세션 초기화 완료");
	}
}
