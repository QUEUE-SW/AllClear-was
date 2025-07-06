package com.allclearwas.domains.session.implement;

import java.util.Map;

import com.allclearwas.common.annotation.Implementation;

import lombok.RequiredArgsConstructor;

@Implementation
@RequiredArgsConstructor
public class SessionManager {

	private final int MAX_CONCURRENT_USERS = 200;
	private final Map<Long, Long> activeUsers;
	private volatile int pendingNotificationCount = 0;


	public void registerUser(Long studentId) {
		activeUsers.put(studentId, System.currentTimeMillis());
	}

	public void remove(Long studentId) {
		activeUsers.remove(studentId);
	}

	public void reset() {
		activeUsers.clear();
	}

	public int getCurrentUserCount() {
		return activeUsers.size();
	}

	public int getMaxConcurrentUsers() {
		return MAX_CONCURRENT_USERS;
	}

	public void removeInactiveUsers(long timeoutMillis) {
		long now = System.currentTimeMillis();
		activeUsers.entrySet().removeIf(entry -> now - entry.getValue() > timeoutMillis);
	}

	public int getPendingNotificationCount() {
		return pendingNotificationCount;
	}

	public void increasePendingNotificationCount(int n) {
		pendingNotificationCount += n;
	}

	public void decreasePendingNotificationCount(int n) {
		pendingNotificationCount -= n;
		if (pendingNotificationCount < 0) pendingNotificationCount = 0;
	}
}
