package com.allclearwas.domains.course.implement;

import java.util.List;

import com.allclearwas.common.annotation.Implementation;
import com.allclearwas.domains.course.dao.CourseListDao;
import com.allclearwas.domains.course.dao.MyCourseListDao;
import com.allclearwas.domains.course.dto.request.CourseFilterReq;
import com.allclearwas.domains.course.repository.CourseRepository;

import lombok.RequiredArgsConstructor;

@Implementation
@RequiredArgsConstructor
public class CourseReader {

	private final CourseRepository courseRepository;

	public List<CourseListDao> findFilteredCourses(CourseFilterReq request) {
		return courseRepository.findFilteredCourses(request);
	}

	public List<MyCourseListDao> findMyCourses(Long studentId) {
		return courseRepository.findMyCourses(studentId);
	}
}
