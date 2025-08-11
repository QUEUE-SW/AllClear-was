package com.allclearwas.domains.seat.implement;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class Heartbeat {

	private final SseEmitterManager sseEmitterManager;

	@Scheduled(fixedDelay = 20_000)
	public void pingAll() {
		sseEmitterManager.getEmitters().forEach((studentId, emitter) -> {
			try {
				emitter.send(SseEmitter.event().comment("ping"));
			} catch (Exception e) {
				sseEmitterManager.removeEmitter(studentId);
			}
		});
	}
}
