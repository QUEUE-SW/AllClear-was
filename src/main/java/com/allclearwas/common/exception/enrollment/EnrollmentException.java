package com.allclearwas.common.exception.enrollment;

import com.allclearwas.common.exception.GlobalException;

import lombok.Getter;

@Getter
public class EnrollmentException extends GlobalException {
	public EnrollmentException(EnrollmentErrorCode enrollmentErrorCode) {
		super(enrollmentErrorCode);
	}
}
