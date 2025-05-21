package com.allclearwas.common.security.handler;

import java.io.IOException;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

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
public class JwtAccessDeniedHandler implements AccessDeniedHandler {

	private final ObjectMapper objectMapper;

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
		AccessDeniedException accessDeniedException) throws IOException, ServletException {
		log.warn("AccessDeniedHandler: {}", accessDeniedException.getMessage());

		response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		response.setContentType("application/json;charset=UTF-8");

		ErrorResponse<?> errorResponse = generateErrorResponse();

		objectMapper.writeValue(response.getWriter(), errorResponse);
	}

	private ErrorResponse<?> generateErrorResponse() {
		ErrorCausedBy errorCausedBy = ErrorCausedBy.of(StatusCode.UNAUTHORIZED, ReasonCode.ACCESS_TO_THE_RESOURCE_IS_FORBIDDEN);
		return ErrorResponse.of(errorCausedBy.getErrorCode(), "해당 리소스에 접근할 권한이 없습니다.");
	}
}
