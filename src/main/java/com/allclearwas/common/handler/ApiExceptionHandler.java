package com.allclearwas.common.handler;

import java.nio.file.AccessDeniedException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.allclearwas.common.exception.GlobalException;
import com.allclearwas.common.response.ErrorResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class ApiExceptionHandler {

	@ExceptionHandler(GlobalException.class)
	public ResponseEntity<?> handleGlobalException(GlobalException globalException) {
		log.warn("exception = {}, error code = {}", globalException.getBaseErrorCode(),
			globalException.errorCausedBy().getErrorCode());
		return ResponseEntity.status(globalException.errorCausedBy().statusCode().getCode())
			.body(ErrorResponse.of(
				globalException.errorCausedBy().getErrorCode(),
				globalException.getErrorMessage()));
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleValidationException(MethodArgumentNotValidException ex) {
		String errorMessage = ex.getBindingResult().getFieldErrors().stream()
			.map(error -> error.getField() + ": " + error.getDefaultMessage())
			.findFirst()
			.orElse("잘못된 입력입니다.");

		return ResponseEntity.badRequest().body(ErrorResponse.of("4000", errorMessage));
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<?> handleInvalidJson(HttpMessageNotReadableException ex) {
		return ResponseEntity.badRequest().body(ErrorResponse.of("4001", "잘못된 요청 형식입니다."));
	}

	@ExceptionHandler(MissingServletRequestParameterException.class)
	public ResponseEntity<?> handleMissingParams(MissingServletRequestParameterException ex) {
		return ResponseEntity.badRequest().body(ErrorResponse.of("4002", "필수 요청 파라미터가 없습니다: " + ex.getParameterName()));
	}

	@ExceptionHandler(AccessDeniedException.class)
	public ResponseEntity<?> handleAccessDenied(AccessDeniedException ex) {
		return ResponseEntity.status(HttpStatus.FORBIDDEN)
			.body(ErrorResponse.of("4030", "접근 권한이 없습니다."));
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleUnknownException(Exception ex) {
		log.error("Unhandled Exception: ", ex);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
			.body(ErrorResponse.of("5000", "예기치 못한 오류가 발생했습니다."));
	}
}
