package com.allclearwas.domains.auth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.allclearwas.common.response.SuccessResponse;
import com.allclearwas.domains.auth.api.AuthApi;
import com.allclearwas.domains.auth.dto.request.SignupReq;
import com.allclearwas.domains.auth.dto.response.SignupRes;
import com.allclearwas.domains.auth.service.AuthService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController implements AuthApi {

	private final AuthService authService;

	@Override
	@PreAuthorize("isAnonymous()")
	@PostMapping("/sign-up")
	public ResponseEntity<?> signUp(@Valid @RequestBody SignupReq signupReq) {
		SignupRes signupRes = authService.signup(signupReq);
		return ResponseEntity.ok(SuccessResponse.of(signupRes));
	}
}
