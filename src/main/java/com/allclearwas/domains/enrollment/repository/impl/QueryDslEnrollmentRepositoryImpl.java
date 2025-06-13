package com.allclearwas.domains.enrollment.repository.impl;

import org.springframework.stereotype.Repository;

import com.allclearwas.domains.course.domain.QCourse;
import com.allclearwas.domains.course.domain.QCourseTime;
import com.allclearwas.domains.enrollment.domain.QEnrollment;
import com.allclearwas.domains.enrollment.repository.QueryDslEnrollmentRepository;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class QueryDslEnrollmentRepositoryImpl implements QueryDslEnrollmentRepository {

	private final JPAQueryFactory queryFactory;
	private final QEnrollment enrollment = QEnrollment.enrollment;
	private final QCourse course = QCourse.course;
	private final QCourseTime courseTime = QCourseTime.courseTime;
	private final QCourseTime courseTimeSub = new QCourseTime("courseTimeSub");

	@Override
	public boolean existsOverlappingTime(Long studentId, Long newCourseId) {
		Boolean exists = queryFactory
			.selectOne()
			.from(enrollment)
			.join(enrollment.course, course)
			.join(courseTime).on(courseTime.course.eq(course))
			.where(
				enrollment.student.id.eq(studentId),
				courseTime.dayOfWeek.in(
					JPAExpressions
						.select(courseTimeSub.dayOfWeek)
						.from(courseTimeSub)
						.where(courseTimeSub.course.id.eq(newCourseId))
				),
				courseTime.startTime.lt(
					JPAExpressions
						.select(courseTimeSub.endTime.min())
						.from(courseTimeSub)
						.where(courseTimeSub.course.id.eq(newCourseId))
				),
				courseTime.endTime.gt(
					JPAExpressions
						.select(courseTimeSub.startTime.max())
						.from(courseTimeSub)
						.where(courseTimeSub.course.id.eq(newCourseId))
				)
			)
			.fetchFirst() != null;

		return exists;
	}

	@Override
	public boolean existsByStudentIdAndCourseName(Long studentId, String courseName) {
		return queryFactory
			.selectOne()
			.from(enrollment)
			.join(enrollment.course, course)
			.where(
				enrollment.student.id.eq(studentId),
				course.name.eq(courseName)
			)
			.fetchFirst() != null;
	}

	@Override
	public Long findCourseIdByEnrollmentId(Long enrollmentId) {
		return queryFactory
			.select(enrollment.course.id)
			.from(enrollment)
			.where(enrollment.id.eq(enrollmentId))
			.fetchOne();
	}
}
