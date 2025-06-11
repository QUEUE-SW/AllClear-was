package com.allclearwas.domains.student.implement;

import com.allclearwas.common.annotation.Implementation;
import com.allclearwas.common.exception.enrollment.EnrollmentErrorCode;
import com.allclearwas.common.exception.enrollment.EnrollmentException;

import lombok.RequiredArgsConstructor;

@Implementation
@RequiredArgsConstructor
public class StudentPolicyValidator {

	public void validateCreditLimit(int currentCredit, int newCourseCredit, int maxCredit) {

		if (currentCredit + newCourseCredit > maxCredit) {
			throw new EnrollmentException(EnrollmentErrorCode.EXCEED_CREDIT_LIMIT);
		}
	}
}
