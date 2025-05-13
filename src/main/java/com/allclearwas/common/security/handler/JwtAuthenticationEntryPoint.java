package com.allclearwas.common.security.handler;

import java.io.IOException;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import com.allclearwas.common.exception.ErrorCausedBy;
import com.allclearwas.common.exception.ReasonCode;
import com.allclearwas.common.exception.StatusCode;
import com.allclearwas.common.response.ErrorResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

	private final ObjectMapper objectMapper;

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
		AuthenticationException authException) throws IOException, ServletException {

		log.warn("Unauthorized : {}", authException.getMessage());

		ErrorResponse<?> errorResponse = generateErrorResponse();

		response.setContentType("application/json;charset=UTF-8");
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

		objectMapper.writeValue(response.getWriter(), errorResponse);
	}

	private ErrorResponse<?> generateErrorResponse() {
		ErrorCausedBy errorCausedBy = ErrorCausedBy.of(StatusCode.UNAUTHORIZED, ReasonCode.INSUFFICIENT_PERMISSIONS);
		return ErrorResponse.of(errorCausedBy.getErrorCode(), "JWT 인증 과정에서 오류가 발생했습니다.");
	}
}
