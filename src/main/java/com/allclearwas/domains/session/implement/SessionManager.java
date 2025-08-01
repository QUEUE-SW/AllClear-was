package com.allclearwas.domains.session.implement;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.springframework.data.redis.core.StringRedisTemplate;

import com.allclearwas.common.annotation.Implementation;

import lombok.RequiredArgsConstructor;

@Implementation
@RequiredArgsConstructor
public class SessionManager {

	private static final String SESSION_KEY_PREFIX = "session:";
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
	}

	public void remove(Long studentId) {
		stringRedisTemplate.delete(SESSION_KEY_PREFIX + studentId);
	}

	public boolean isActive(Long studentId) {
		Boolean hasKey = stringRedisTemplate.hasKey(SESSION_KEY_PREFIX + studentId);
		return Boolean.TRUE.equals(hasKey);
	}

	public void reset() {
		Set<String> keys = stringRedisTemplate.keys(SESSION_KEY_PREFIX + "*");
		if (keys != null && !keys.isEmpty()) {
			stringRedisTemplate.delete(keys);
		}
	}

	public int getCurrentUserCount() {
		Set<String> keys = stringRedisTemplate.keys(SESSION_KEY_PREFIX + "*");
		return keys != null ? keys.size() : 0;
	}

	public int getMaxConcurrentUsers() {
		return MAX_CONCURRENT_USERS;
	}
}
