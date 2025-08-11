package com.allclearwas.config;

import org.springframework.stereotype.Component;

import com.allclearwas.domains.seat.implement.SeatManager;
import com.allclearwas.domains.session.implement.SessionManager;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CommonInitializer {

	private final SessionManager sessionManager;
	private final SeatManager seatManager;

	@PostConstruct
	public void init() {
		sessionManager.reset();
		seatManager.reset();
		System.out.println("✅ Redis 세션과 자리수 초기화 완료");
	}
}
