package com.allclearwas.domains.session.implement;

import java.util.Map;

import org.springframework.scheduling.annotation.Async;
import org.springframework.web.client.RestTemplate;

import com.allclearwas.common.annotation.Implementation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Implementation
@RequiredArgsConstructor
public class SessionNotifier {

	private final RestTemplate restTemplate;
	private final String queueUrl = "http://queue-was-dev:8081/api/v1/sse/notify";

	@Async
	public void notify(int count) {
		try {
			Map<String, Integer> payload = Map.of("count", count);
			restTemplate.postForEntity(queueUrl, payload, Void.class);
		} catch (Exception e) {
			log.error("Queue notify 실패 - count={}, error={}", count, e.getMessage());
		}
	}
}
