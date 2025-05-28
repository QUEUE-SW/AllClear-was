package com.allclearwas.domains.enrollment.implement;

import java.util.List;

import com.allclearwas.common.annotation.Implementation;
import com.allclearwas.domains.enrollment.dao.CourseEnrollmentCountDao;
import com.allclearwas.domains.enrollment.repository.EnrollmentRepository;

import lombok.RequiredArgsConstructor;

@Implementation
@RequiredArgsConstructor
public class EnrollmentReader {

	private final EnrollmentRepository enrollmentRepository;

	public List<CourseEnrollmentCountDao> countByCourseIds(List<Long> courseIds) {
		return enrollmentRepository.countByCourseIds(courseIds);
	}
}
