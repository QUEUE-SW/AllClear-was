package com.allclearwas.domains.enrollment.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.allclearwas.domains.course.domain.QCourse;
import com.allclearwas.domains.enrollment.dao.CourseEnrollmentCountDao;
import com.allclearwas.domains.enrollment.domain.QEnrollment;
import com.allclearwas.domains.enrollment.repository.QueryDslEnrollmentRepository;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class QueryDslEnrollmentRepositoryImpl implements QueryDslEnrollmentRepository {

	private final JPAQueryFactory queryFactory;
	private final QEnrollment enrollment = QEnrollment.enrollment;
	private final QCourse course = QCourse.course;

	@Override
	public List<CourseEnrollmentCountDao> countByCourseIds(List<Long> courseIds) {
		return queryFactory
			.select(Projections.constructor(CourseEnrollmentCountDao.class,
				enrollment.course.id,
				enrollment.count()))
			.from(enrollment)
			.join(enrollment.course, course)
			.where(course.id.in(courseIds))
			.groupBy(course.id)
			.fetch();
	}
}
