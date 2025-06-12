package com.allclearwas.domains.enrollment.implement;

import java.util.Optional;

import com.allclearwas.common.annotation.Implementation;
import com.allclearwas.domains.enrollment.domain.Enrollment;
import com.allclearwas.domains.enrollment.repository.EnrollmentRepository;

import lombok.RequiredArgsConstructor;

@Implementation
@RequiredArgsConstructor
public class EnrollmentReader {

	private final EnrollmentRepository enrollmentRepository;

	public Optional<Enrollment> read(Long enrollmentId) {
		return enrollmentRepository.findById(enrollmentId);
	}

	public boolean isAlreadyEnrolled(Long studentId, Long courseId) {
		return enrollmentRepository.existsByStudentIdAndCourseId(studentId, courseId);
	}

	public boolean isOwnedByStudent(Long enrollmentId, Long studentId) {
		return enrollmentRepository.existsByEnrollmentIdAndStudentId(enrollmentId, studentId);
	}

	public boolean existsByStudentIdAndSameCourseName(Long studentId, String courseName) {
		return enrollmentRepository.existsByStudentIdAndCourseName(studentId, courseName);
	}

	public boolean existsOverlappingTime(Long studentId, Long courseId) {
		return enrollmentRepository.existsOverlappingTime(studentId, courseId);
	}

}
