package com.allclearwas.domains.course.implement;

import java.util.List;

import com.allclearwas.common.annotation.Implementation;
import com.allclearwas.domains.course.domain.Course;
import com.allclearwas.domains.course.domain.CourseTime;
import com.allclearwas.domains.course.domain.QCourse;
import com.allclearwas.domains.course.domain.QCourseInfo;
import com.allclearwas.domains.course.dto.request.CourseFilterRequest;
import com.allclearwas.domains.course.repository.CourseTimeRepository;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@Implementation
@RequiredArgsConstructor
public class CourseReader {

	private final JPAQueryFactory queryFactory;
	private final CourseTimeRepository courseTimeRepository;

	public List<Course> findAllCourses(CourseFilterRequest request) {
		QCourse course = QCourse.course;
		QCourseInfo courseInfo = QCourseInfo.courseInfo;

		BooleanBuilder builder = new BooleanBuilder();

		builder.and(course.courseInfo.eq(courseInfo));

		if (request.category() != null) {
			builder.and(courseInfo.category.eq(request.category()));
		}

		if (request.grade() != null) {
			builder.and(courseInfo.grade.eq(request.grade()));
		}

		if (request.department() != null) {
			builder.and(courseInfo.department.eq(request.department()));
		}

		if (request.code() != null && !request.code().isBlank()) {
			builder.and(course.courseCode.eq(request.code()));
		}

		return queryFactory
			.selectFrom(course)
			.join(course.courseInfo, courseInfo)
			.where(builder)
			.fetch();
	}

	public List<CourseTime> findCourseTimesByCourseId(Long courseId) {
		return courseTimeRepository.findByCourseId(courseId);
	}

	public List<CourseTime> findByCourseId(List<Long> courseId) {
		return courseTimeRepository.findByCourseIds(courseId);
	}
}
