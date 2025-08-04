package com.allclearwas.domains.seat.implement;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import lombok.Getter;

@Getter
@Component
public class SseEmitterManager {
	private final Map<Long, SseEmitter> emitters = new ConcurrentHashMap<>();
	private final Map<Long, List<Long>> subscribedCourses = new ConcurrentHashMap<>();

	public void addEmitter(Long studentId, SseEmitter emitter, List<Long> courseIds) {
		emitters.put(studentId, emitter);
		subscribedCourses.put(studentId, courseIds);
	}

	public void removeEmitter(Long studentId) {
		emitters.remove(studentId);
		subscribedCourses.remove(studentId);
	}

	public SseEmitter getEmitter(Long studentId) {
		return emitters.get(studentId);
	}
}

