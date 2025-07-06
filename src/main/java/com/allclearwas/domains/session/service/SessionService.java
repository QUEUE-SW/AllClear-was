package com.allclearwas.domains.session.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.allclearwas.domains.session.implement.SessionManager;
import com.allclearwas.domains.session.implement.SessionNotifier;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class SessionService {

	private final SessionManager sessionManager;
	private final SessionNotifier sessionNotifier;

	public void save(Long studentId) {
		sessionManager.registerUser(studentId);
	}

	public void remove(Long studentId) {
		sessionManager.remove(studentId);
	}

	@Scheduled(fixedDelay = 10_000)
	public void checkAndNotifyQueue() {
		int current = sessionManager.getCurrentUserCount();
		int capacity = sessionManager.getMaxConcurrentUsers();
		int available = capacity - current;
		log.info("[Session] 현재 세션 수: {} / {}, 여유 슬롯: {}", current, capacity, available);
		if (available > 0) {
			log.info("[Session] 여유 슬롯 {}개 발견, 대기열 서버에 알림 전송", available);
			sessionNotifier.notify(available);
		}
	}

	@Scheduled(fixedDelay = 60_000)
	public void cleanInactiveUsers() {
		int before = sessionManager.getCurrentUserCount();
		sessionManager.removeInactiveUsers(180_000);
		int after = sessionManager.getCurrentUserCount();
		log.info("[Session] {}명 제거됨 (before: {}, after: {})", before - after, before, after);
	}
}
