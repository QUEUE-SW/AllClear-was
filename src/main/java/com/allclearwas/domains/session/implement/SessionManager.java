package com.allclearwas.domains.session.implement;

import java.util.concurrent.TimeUnit;

import org.springframework.data.redis.core.StringRedisTemplate;

import com.allclearwas.common.annotation.Implementation;

import lombok.RequiredArgsConstructor;

@Implementation
@RequiredArgsConstructor
public class SessionManager {

	private static final String SESSION_KEY_PREFIX = "session:";
	private static final String SESSION_USER_SET_KEY = "session:users";
	private static final long SESSION_TTL_MILLIS = 600_000;
	private final StringRedisTemplate stringRedisTemplate;
	private final int MAX_CONCURRENT_USERS = 200;

	public void registerUser(Long studentId) {
		String key = SESSION_KEY_PREFIX + studentId;
		stringRedisTemplate.opsForValue().set(
			key,
			"active",
			SESSION_TTL_MILLIS,
			TimeUnit.MILLISECONDS
		);

		stringRedisTemplate.opsForSet().add(SESSION_USER_SET_KEY, studentId.toString());
	}

	public void remove(Long studentId) {
		stringRedisTemplate.delete(SESSION_KEY_PREFIX + studentId.toString());
		stringRedisTemplate.opsForSet().remove(SESSION_USER_SET_KEY, studentId.toString());
	}

	public boolean isActive(Long studentId) {
		Boolean hasKey = stringRedisTemplate.hasKey(SESSION_KEY_PREFIX + studentId.toString());
		return Boolean.TRUE.equals(hasKey);
	}

	public void reset() {
		stringRedisTemplate.delete(SESSION_USER_SET_KEY);
	}

	public int getCurrentUserCount() {
		Long count = stringRedisTemplate.opsForSet().size(SESSION_USER_SET_KEY);
		return count != null ? count.intValue() : 0;
	}

	public int getMaxConcurrentUsers() {
		return MAX_CONCURRENT_USERS;
	}
}
