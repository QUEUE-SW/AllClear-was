package com.allclearwas.domains.auth.implement;

import com.allclearwas.common.annotation.Implementation;
import com.allclearwas.common.jwt.AccessTokenProvider;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Implementation
@RequiredArgsConstructor
public class TokenGenerator {
	private final AccessTokenProvider accessTokenProvider;

	public String generateToken(Long studentId, String identifier) {
		String token = accessTokenProvider.generateToken(studentId, identifier);
		log.debug("Student: {} Token: {}", identifier, token);

		return token;
	}
}
