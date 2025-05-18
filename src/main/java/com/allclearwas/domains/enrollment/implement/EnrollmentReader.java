package com.allclearwas.domains.enrollment.implement;

import java.util.List;

import com.allclearwas.common.annotation.Implementation;
import com.allclearwas.domains.enrollment.domain.Enrollment;
import com.allclearwas.domains.enrollment.repository.EnrollmentRepository;
import com.allclearwas.domains.student.domain.Student;

import lombok.RequiredArgsConstructor;

@Implementation
@RequiredArgsConstructor
public class EnrollmentReader {

	private final EnrollmentRepository enrollmentRepository;

	public List<Enrollment> findEnrollmentsByStudent(Student student) {
		return enrollmentRepository.findByStudent(student);
	}
}
