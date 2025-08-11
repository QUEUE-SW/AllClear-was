package com.allclearwas.domains.seat.implement;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class Heartbeat {

	private final SseEmitterManager sseEmitterManager;

	@Scheduled(fixedDelay = 20_000)
	public void pingAll() {
		sseEmitterManager.getEmitters().forEach((studentId, emitter) -> {
			try {
				emitter.send(SseEmitter.event().comment("ping"));
				log.info("Heartbeat sse 알림 성공");
			} catch (Exception e) {
				sseEmitterManager.removeEmitter(studentId);
			}
		});
	}
}
