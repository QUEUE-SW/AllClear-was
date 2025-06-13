package com.allclearwas.common.exception.enrollment;

import com.allclearwas.common.exception.BaseErrorCode;
import com.allclearwas.common.exception.ErrorCausedBy;
import com.allclearwas.common.exception.ReasonCode;
import com.allclearwas.common.exception.StatusCode;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EnrollmentErrorCode implements BaseErrorCode {

	ENROLLMENT_NOT_FOUND(StatusCode.NOT_FOUND, ReasonCode.REQUESTED_RESOURCE_NOT_FOUND, "수강 신청 정보를 찾을 수 없습니다."),
	ALREADY_ENROLLED(StatusCode.CONFLICT, ReasonCode.RESOURCE_ALREADY_EXISTS, "이미 신청한 과목입니다."),
	NOT_ALLOWED_OTHER_MAJOR(StatusCode.CONFLICT, ReasonCode.REQUEST_CONFLICT_WITH_CURRENT_STATE_OF_RESOURCE,
		"다른 학과 과목입니다."),
	ALREADY_ENROLLED_SAME_COURSE_NAME(StatusCode.CONFLICT, ReasonCode.REQUEST_CONFLICT_WITH_CURRENT_STATE_OF_RESOURCE,
		"동일 과목의 다른 분반을 중복 신청할 수 없습니다."),
	EXCEED_CREDIT_LIMIT(StatusCode.CONFLICT, ReasonCode.REQUEST_CONFLICT_WITH_CURRENT_STATE_OF_RESOURCE,
		"최대 신청 학점을 초과했습니다."),
	COURSE_TIME_OVERLAP(StatusCode.CONFLICT, ReasonCode.REQUEST_CONFLICT_WITH_CURRENT_STATE_OF_RESOURCE,
		"기존 신청한 과목과 시간이 중복됩니다."),
	NO_AVAILABLE_SEATS(StatusCode.CONFLICT, ReasonCode.REQUEST_CONFLICT_WITH_CURRENT_STATE_OF_RESOURCE,
		"해당 과목의 여석이 없습니다."),
	UNAUTHORIZED_STUDENT(StatusCode.UNAUTHORIZED, ReasonCode.INSUFFICIENT_PERMISSIONS, "다른 학생의 수강신청 정보에 접근할 수 없습니다.");

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
