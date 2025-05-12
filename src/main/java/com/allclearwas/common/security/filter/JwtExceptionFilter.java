package com.allclearwas.common.security.filter;

import java.io.IOException;

import org.springframework.web.filter.OncePerRequestFilter;

import com.allclearwas.common.exception.GlobalException;
import com.allclearwas.common.response.ErrorResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class JwtExceptionFilter extends OncePerRequestFilter {

	private final ObjectMapper objectMapper;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
		FilterChain filterChain) throws ServletException, IOException {

		try {
			filterChain.doFilter(request, response);
		} catch (ServletException e) {
			Throwable cause = e.getCause();
			if (cause instanceof GlobalException globalException) {
				sendJwtError(response, globalException);
			}
		}
	}

	private void sendJwtError(HttpServletResponse response, GlobalException e) throws IOException {
		response.setContentType("application/json;charset=UTF-8");
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		ErrorResponse<?> errorResponse = ErrorResponse.of(e.errorCausedBy().getErrorCode(),
			e.getErrorMessage());
		response.getWriter().write(objectMapper.writeValueAsString(errorResponse));
	}
}
