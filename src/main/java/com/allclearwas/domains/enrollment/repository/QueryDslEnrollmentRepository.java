package com.allclearwas.domains.enrollment.repository;

import java.util.List;

import com.allclearwas.domains.course.domain.CourseTime;

public interface QueryDslEnrollmentRepository {

	boolean existsOverlappingTime(Long studentId, List<CourseTime> newTimes);
}
