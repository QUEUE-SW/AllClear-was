package com.allclearwas.domains.enrollment.implement;

import com.allclearwas.common.annotation.Implementation;
import com.allclearwas.domains.enrollment.domain.Enrollment;
import com.allclearwas.domains.enrollment.repository.EnrollmentRepository;

import lombok.RequiredArgsConstructor;

@Implementation
@RequiredArgsConstructor
public class EnrollmentDeleter {

	private final EnrollmentRepository enrollmentRepository;

	public void delete(Enrollment enrollment) {
		enrollmentRepository.delete(enrollment);
	}
}
