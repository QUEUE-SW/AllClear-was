package com.allclearwas.domains.course.repository;

import java.util.List;

import com.allclearwas.domains.course.dao.CourseListDao;
import com.allclearwas.domains.course.dto.request.CourseFilterReq;

public interface QueryDslCourseRepository {
	List<CourseListDao> findFilteredCourses(CourseFilterReq request);
}
