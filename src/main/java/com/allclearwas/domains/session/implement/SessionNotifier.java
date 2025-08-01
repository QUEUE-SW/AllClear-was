package com.allclearwas.domains.session.implement;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Async;

import com.allclearwas.common.annotation.Implementation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Implementation
@RequiredArgsConstructor
public class SessionNotifier {

	private final StringRedisTemplate stringRedisTemplate;
	private final String CHANNEL_NAME = "entrance-channel";

	@Async
	public void notify(int count) {
		try {
			stringRedisTemplate.convertAndSend(CHANNEL_NAME, String.valueOf(count));
		} catch (Exception e) {
			log.error("Queue notify 실패 - count={}, error={}", count, e.getMessage());
		}
	}
}
