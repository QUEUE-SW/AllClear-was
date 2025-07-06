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

	public void reset() {
		sessionManager.reset();
	}

	public boolean isFull() {
		return sessionManager.getMaxConcurrentUsers() < sessionManager.getCurrentUserCount();
	}

	@Scheduled(fixedDelay = 10_000)
	public void checkAndNotifyQueue() {
		int current = sessionManager.getCurrentUserCount();
		int capacity = sessionManager.getMaxConcurrentUsers();
		int pending = sessionManager.getPendingNotificationCount();

		int available = capacity - current;
		int effectiveAvailable = available - pending;

		log.info("[Session] 현재 세션 수: {} / {}, 여유 슬롯: {}, 미처리 알림 수: {}, 실제 통보할 여유 슬롯: {}",
			current, capacity, available, pending, effectiveAvailable);

		if (effectiveAvailable > 0) {
			sessionNotifier.notify(effectiveAvailable);  // 대기열 서버에 알림
			sessionManager.increasePendingNotificationCount(effectiveAvailable);
		}
	}

	@Scheduled(fixedDelay = 60_000)
	public void cleanInactiveUsers() {
		int before = sessionManager.getCurrentUserCount();
		sessionManager.removeInactiveUsers(600_000);
		int after = sessionManager.getCurrentUserCount();
		log.info("[Session] {}명 제거됨 (before: {}, after: {})", before - after, before, after);
	}

	public void notifySuccess(int count) {
		sessionManager.decreasePendingNotificationCount(count);
	}
}
