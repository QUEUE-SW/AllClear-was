package com.allclearwas.domains.course.implement;

import java.util.List;

import com.allclearwas.common.annotation.Implementation;
import com.allclearwas.domains.course.domain.Course;
import com.allclearwas.domains.course.domain.CourseTime;
import com.allclearwas.domains.course.repository.CourseRepository;
import com.allclearwas.domains.course.repository.CourseTimeRepository;

import lombok.RequiredArgsConstructor;

@Implementation
@RequiredArgsConstructor
public class CourseReader {

	private final CourseRepository courseRepository;
	private final CourseTimeRepository courseTimeRepository;

	public List<Course> findAllCourses() {
		return courseRepository.findAll();
	}

	public List<CourseTime> findCourseTimesByCourseId(Long courseId) {
		return courseTimeRepository.findByCourseId(courseId);
	}
}
