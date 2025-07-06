package com.allclearwas.domains.session.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.allclearwas.common.response.SuccessResponse;
import com.allclearwas.domains.session.service.SessionService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/session")
@RequiredArgsConstructor
public class SessionController {

	private final SessionService sessionService;

	@PostMapping("/notify-login-success")
	public ResponseEntity<?> notifyLoginSuccess(@RequestParam int count) {
		sessionService.notifySuccess(count);
		return ResponseEntity.ok(SuccessResponse.noContent());
	}
}
