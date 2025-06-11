package com.allclearwas.domains.enrollment.implement;

import com.allclearwas.common.exception.enrollment.EnrollmentErrorCode;
import com.allclearwas.common.exception.enrollment.EnrollmentException;

public class EnrollmentValidator {

	public void validateCreditLimit(int currentCredit, int newCourseCredit, int maxCredit) {

		if (currentCredit + newCourseCredit > maxCredit) {
			throw new EnrollmentException(EnrollmentErrorCode.EXCEED_CREDIT_LIMIT);
		}
	}

}
