package com.allclearwas.domains.enrollment.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.allclearwas.domains.course.domain.CourseTime;
import com.allclearwas.domains.course.domain.QCourse;
import com.allclearwas.domains.course.domain.QCourseTime;
import com.allclearwas.domains.enrollment.domain.QEnrollment;
import com.allclearwas.domains.enrollment.repository.QueryDslEnrollmentRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class QueryDslEnrollmentRepositoryImpl implements QueryDslEnrollmentRepository {

	private final JPAQueryFactory queryFactory;
	private final QEnrollment enrollment = QEnrollment.enrollment;
	private final QCourse course = QCourse.course;
	private final QCourseTime courseTime = QCourseTime.courseTime;

	@Override
	public boolean existsOverlappingTime(Long studentId, List<CourseTime> newTimes) {
		for (CourseTime newTime : newTimes) {
			Boolean exists = queryFactory
				.selectOne()
				.from(enrollment)
				.join(enrollment.course, course)
				.join(courseTime).on(courseTime.course.eq(course))
				.where(
					enrollment.student.id.eq(studentId),
					courseTime.dayOfWeek.eq(newTime.getDayOfWeek()),
					courseTime.startTime.lt(newTime.getEndTime()),
					courseTime.endTime.gt(newTime.getStartTime())
				)
				.fetchFirst() != null;

			if (exists) {
				return true;
			}
		}
		return false;
	}
}
