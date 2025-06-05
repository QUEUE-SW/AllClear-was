package com.allclearwas.domains.enrollment.implement;

import java.util.List;

import com.allclearwas.common.annotation.Implementation;
import com.allclearwas.domains.course.domain.CourseTime;
import com.allclearwas.domains.enrollment.repository.EnrollmentRepository;

import lombok.RequiredArgsConstructor;

@Implementation
@RequiredArgsConstructor
public class EnrollmentReader {

	private final EnrollmentRepository enrollmentRepository;

	public boolean isAlreadyEnrolled(Long studentId, Long courseId) {
		return enrollmentRepository.existsByStudentIdAndCourseId(studentId, courseId);
	}

	public boolean existsOverlappingTime(Long studentId, List<CourseTime> newTimes) {
		return enrollmentRepository.existsOverlappingTime(studentId, newTimes);
	}
}
