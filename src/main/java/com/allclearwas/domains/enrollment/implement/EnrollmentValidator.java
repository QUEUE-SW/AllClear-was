package com.allclearwas.domains.enrollment.implement;

import com.allclearwas.common.annotation.Implementation;
import com.allclearwas.common.exception.enrollment.EnrollmentErrorCode;
import com.allclearwas.common.exception.enrollment.EnrollmentException;
import com.allclearwas.domains.student.type.Major;

import lombok.RequiredArgsConstructor;

@Implementation
@RequiredArgsConstructor
public class EnrollmentValidator {

	public void validateCreditLimit(int currentCredit, int newCourseCredit, int maxCredit) {

		if (currentCredit + newCourseCredit > maxCredit) {
			throw new EnrollmentException(EnrollmentErrorCode.EXCEED_CREDIT_LIMIT);
		}
	}

	public void validateMajorPermission(Major studentMajor, Major courseMajor) {
		if (courseMajor == Major.ALL)
			return;

		if (!studentMajor.equals(courseMajor)) {
			throw new EnrollmentException(EnrollmentErrorCode.NOT_ALLOWED_OTHER_MAJOR);
		}
	}

}
