package com.allclearwas.common.exception.auth;

import com.allclearwas.common.exception.BaseErrorCode;
import com.allclearwas.common.exception.ErrorCausedBy;
import com.allclearwas.common.exception.ReasonCode;
import com.allclearwas.common.exception.StatusCode;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AuthErrorCode implements BaseErrorCode {

	PASSWORD_MISMATCH(StatusCode.UNAUTHORIZED, ReasonCode.MISSING_OR_INVALID_AUTHENTICATION_CREDENTIALS, "입력한 비밀번호가 현재 비밀번호와 일치하지 않습니다.");

	private final StatusCode statusCode;
	private final ReasonCode reasonCode;
	private final String message;

	@Override
	public ErrorCausedBy errorCausedBy() {
		return ErrorCausedBy.of(statusCode, reasonCode);
	}

	@Override
	public String getErrorMessage() {
		return message;
	}
}
