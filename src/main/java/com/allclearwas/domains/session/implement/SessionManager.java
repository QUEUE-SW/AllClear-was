package com.allclearwas.domains.session.implement;

import java.util.Map;

import com.allclearwas.common.annotation.Implementation;
import com.allclearwas.common.exception.auth.AuthErrorCode;
import com.allclearwas.common.exception.auth.AuthException;

import lombok.RequiredArgsConstructor;

@Implementation
@RequiredArgsConstructor
public class SessionManager {

	private final int MAX_CONCURRENT_USERS = 200;
	private final Map<Long, Long> activeUsers;

	public void registerUser(Long studentId) {
		if (activeUsers.size() >= MAX_CONCURRENT_USERS) {
			throw new AuthException(AuthErrorCode.FULL_CONCURRENT_USERS);
		}
		activeUsers.put(studentId, System.currentTimeMillis());
	}

	public void remove(Long studentId) {
		activeUsers.remove(studentId);
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
}
