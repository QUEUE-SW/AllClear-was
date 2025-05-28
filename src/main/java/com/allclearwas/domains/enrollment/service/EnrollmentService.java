package com.allclearwas.domains.enrollment.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.allclearwas.domains.enrollment.dao.CourseEnrollmentCountDao;
import com.allclearwas.domains.enrollment.dto.response.CourseEnrollmentCountRes;
import com.allclearwas.domains.enrollment.implement.EnrollmentReader;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class EnrollmentService {

	private final EnrollmentReader enrollmentReader;

	public List<CourseEnrollmentCountRes> getEnrolledCount(List<Long> courseIds) {
		List<CourseEnrollmentCountDao> daoList = enrollmentReader.countByCourseIds(courseIds);
		return daoList.stream()
			.map(CourseEnrollmentCountRes::of)
			.toList();
	}
}
