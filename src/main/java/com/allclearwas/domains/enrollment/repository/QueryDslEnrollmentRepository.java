package com.allclearwas.domains.enrollment.repository;

import java.util.List;

import com.allclearwas.domains.enrollment.dao.CourseEnrollmentCountDao;

public interface QueryDslEnrollmentRepository {
	List<CourseEnrollmentCountDao> countByCourseIds(List<Long> courseIds);
}
