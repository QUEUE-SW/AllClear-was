package com.allclearwas.domains.seat.implement;

import java.io.IOException;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class SseAsyncSender {

	@Async("sseAsyncExecutor")
	public void send(SseEmitter emitter, String event, Object data) {
		try {
			emitter.send(SseEmitter.event()
				.name(event)
				.data(data));
			log.info("✅ send 성공!!");
		} catch (IOException e) {
			log.warn("🚨 SSE 전송 실패: event={}, message={}", event, e.getMessage());
		}
	}
}

