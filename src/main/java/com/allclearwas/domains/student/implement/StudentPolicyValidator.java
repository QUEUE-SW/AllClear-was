package com.allclearwas.domains.student.implement;

import com.allclearwas.common.annotation.Implementation;
import com.allclearwas.common.exception.enrollment.EnrollmentErrorCode;
import com.allclearwas.common.exception.enrollment.EnrollmentException;
import com.allclearwas.common.exception.student.StudentErrorCode;
import com.allclearwas.common.exception.student.StudentException;
import com.allclearwas.domains.student.domain.StudentPolicy;

import lombok.RequiredArgsConstructor;

@Implementation
@RequiredArgsConstructor
public class StudentPolicyValidator {

	private final StudentPolicyReader studentPolicyReader;

	public StudentPolicy validateCreditLimit(Long studentId, int newCourseCredit) {
		StudentPolicy policy = studentPolicyReader.read(studentId)
			.orElseThrow(() -> new StudentException(StudentErrorCode.STUDENT_POLICY_NOT_FOUND));

		if (policy.getCurrentCredits() + newCourseCredit > policy.getMaxCredits()) {
			throw new EnrollmentException(EnrollmentErrorCode.EXCEED_CREDIT_LIMIT);
		}

		return policy;
	}
}
