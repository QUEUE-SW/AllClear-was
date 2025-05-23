package com.allclearwas.domains.course.implement;

import java.util.List;

import com.allclearwas.common.annotation.Implementation;
import com.allclearwas.domains.course.dao.CourseListDao;
import com.allclearwas.domains.course.domain.CourseTime;
import com.allclearwas.domains.course.dto.request.CourseFilterRequest;
import com.allclearwas.domains.course.repository.CourseRepository;
import com.allclearwas.domains.course.repository.CourseTimeRepository;

import lombok.RequiredArgsConstructor;

@Implementation
@RequiredArgsConstructor
public class CourseReader {

	private final CourseTimeRepository courseTimeRepository;
	private final CourseRepository courseRepository;

	public List<CourseListDao> findFilteredCourses(CourseFilterRequest request) {
		return courseRepository.findFilteredCourses(request);
	}

	public List<CourseTime> findByCourseId(List<Long> courseId) {
		return courseTimeRepository.findByCourseIds(courseId);
	}
}
