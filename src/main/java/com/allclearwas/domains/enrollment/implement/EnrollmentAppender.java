package com.allclearwas.domains.enrollment.implement;

import com.allclearwas.common.annotation.Implementation;
import com.allclearwas.domains.course.domain.Course;
import com.allclearwas.domains.enrollment.domain.Enrollment;
import com.allclearwas.domains.enrollment.repository.EnrollmentRepository;
import com.allclearwas.domains.student.domain.Student;

import lombok.RequiredArgsConstructor;

@Implementation
@RequiredArgsConstructor
public class EnrollmentAppender {

	private final EnrollmentRepository enrollmentRepository;

	public Enrollment save(Student student, Course course) {
		Enrollment enrollment = Enrollment.of(student, course);
		return enrollmentRepository.save(enrollment);
	}
}
