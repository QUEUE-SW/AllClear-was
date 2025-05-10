package com.allclearwas.common.exception.student;

import com.allclearwas.common.exception.BaseErrorCode;
import com.allclearwas.common.exception.ErrorCausedBy;
import com.allclearwas.common.exception.ReasonCode;
import com.allclearwas.common.exception.StatusCode;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum StudentErrorCode implements BaseErrorCode {

	STUDENT_NOT_FOUND(StatusCode.NOT_FOUND, ReasonCode.REQUESTED_RESOURCE_NOT_FOUND, "해당 학생이 존재하지 않습니다.");

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
