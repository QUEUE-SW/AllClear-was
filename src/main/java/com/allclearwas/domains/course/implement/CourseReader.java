package com.allclearwas.domains.course.implement;

import java.util.List;
import java.util.Optional;

import com.allclearwas.common.annotation.Implementation;
import com.allclearwas.domains.course.dao.CourseListDao;
import com.allclearwas.domains.course.dao.MyCourseListDao;
import com.allclearwas.domains.course.domain.Course;
import com.allclearwas.domains.course.domain.CourseTime;
import com.allclearwas.domains.course.dto.request.CourseFilterReq;
import com.allclearwas.domains.course.repository.CourseRepository;
import com.allclearwas.domains.course.repository.CourseTimeRepository;
import com.allclearwas.domains.enrollment.dto.response.CourseEnrollmentCountRes;

import lombok.RequiredArgsConstructor;

@Implementation
@RequiredArgsConstructor
public class CourseReader {

	private final CourseRepository courseRepository;
	private final CourseTimeRepository courseTimeRepository;

	public List<CourseListDao> findFilteredCourses(CourseFilterReq request) {
		return courseRepository.findFilteredCourses(request);
	}

	public List<MyCourseListDao> findMyCourses(Long studentId) {
		return courseRepository.findMyCourses(studentId);
	}

	public Optional<Course> read(Long courseId) {
		return courseRepository.findById(courseId);
	}

	public List<CourseTime> getCourseTimesByCourseId(Long courseId) {
		return courseTimeRepository.findByCourseId(courseId);
	}

	public List<CourseEnrollmentCountRes> getEnrollmentCount(List<Long> courseIds) {
		return courseRepository.findParticipantsByCourseIds(courseIds);
	}

	public Optional<Course> readWithPessimisticLock(Long courseId) {
		return courseRepository.findWithPessimisticLock(courseId);
	}
}

