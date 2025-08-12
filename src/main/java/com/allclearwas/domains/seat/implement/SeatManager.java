package com.allclearwas.domains.seat.implement;

import org.springframework.data.redis.core.StringRedisTemplate;

import com.allclearwas.common.annotation.Implementation;

import lombok.RequiredArgsConstructor;

@Implementation
@RequiredArgsConstructor
public class SeatManager {

	private final StringRedisTemplate stringRedisTemplate;
	private static final String KEY_PREFIX = "course:";
	private static final String KEY_SUFFIX = ":remaining";

	public void reset() {
		for (int i = 1; i <= 120; i++) {
			stringRedisTemplate.opsForValue()
				.set(KEY_PREFIX + i + KEY_SUFFIX, "40");
		}
	}
}
