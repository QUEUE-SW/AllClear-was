package com.allclearwas.domains.enrollment.implement;

import com.allclearwas.common.annotation.Implementation;
import com.allclearwas.domains.enrollment.repository.EnrollmentRepository;

import lombok.RequiredArgsConstructor;

@Implementation
@RequiredArgsConstructor
public class EnrollmentReader {

	private final EnrollmentRepository enrollmentRepository;

	public boolean isAlreadyEnrolled(Long studentId, Long courseId) {
		return enrollmentRepository.existsByStudentIdAndCourseId(studentId, courseId);
	}

	public boolean existsOverlappingTime(Long studentId, Long courseId) {
		return enrollmentRepository.existsOverlappingTime(studentId, courseId);
	}
}
