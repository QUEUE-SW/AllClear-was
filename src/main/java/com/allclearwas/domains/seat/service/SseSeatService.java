package com.allclearwas.domains.seat.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.allclearwas.domains.seat.implement.SseAsyncSender;
import com.allclearwas.domains.seat.implement.SseEmitterManager;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SseSeatService {

	private final SseEmitterManager emitterManager;
	private final SseAsyncSender asyncSender;
	private final RedisTemplate<String, String> redisTemplate;

	public SseEmitter subscribe(Long studentId, List<Long> courseIds) {
		SseEmitter emitter = new SseEmitter(Long.MAX_VALUE);
		emitterManager.addEmitter(studentId, emitter, courseIds);

		asyncSender.send(emitter, "init", Map.of("status", "connected"));
		
		for (Long courseId : courseIds) {
			String remaining = redisTemplate.opsForValue().get("course:" + courseId + ":remaining");
			asyncSender.send(emitter, "seat", Map.of(
				"courseId", courseId,
				"remaining", remaining
			));
		}

		emitter.onCompletion(() -> emitterManager.removeEmitter(studentId));
		emitter.onTimeout(() -> emitterManager.removeEmitter(studentId));
		emitter.onError((e) -> emitterManager.removeEmitter(studentId));

		return emitter;
	}

	public void notifyRemainingChanged(Long courseId, String remaining) {
		for (Map.Entry<Long, List<Long>> entry : emitterManager.getSubscribedCourses().entrySet()) {
			Long studentId = entry.getKey();
			List<Long> subscribed = entry.getValue();

			if (subscribed.contains(courseId)) {
				SseEmitter emitter = emitterManager.getEmitter(studentId);
				if (emitter != null) {
					asyncSender.send(emitter, "seat", Map.of(
						"courseId", courseId,
						"remaining", remaining
					));
				}
			}
		}
	}
}
