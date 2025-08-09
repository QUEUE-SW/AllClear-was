package com.allclearwas.domains.seat.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.allclearwas.common.security.authentication.SecurityUserDetails;
import com.allclearwas.domains.seat.service.SseSeatService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/seats")
public class SseSeatController {

	private final SseSeatService sseSeatService;

	@GetMapping(value = "/subscribe", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public SseEmitter subscribe(@RequestParam List<Long> courseIds,
		@AuthenticationPrincipal SecurityUserDetails userDetails) {
		log.info("subscribe 시작");
		Long studentId = userDetails.getStudentId();
		return sseSeatService.subscribe(studentId, courseIds);
	}
}
