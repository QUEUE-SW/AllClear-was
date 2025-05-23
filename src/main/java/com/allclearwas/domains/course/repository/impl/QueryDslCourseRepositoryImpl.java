package com.allclearwas.domains.course.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.allclearwas.domains.course.dao.CourseListDao;
import com.allclearwas.domains.course.domain.QCourse;
import com.allclearwas.domains.course.domain.QCourseInfo;
import com.allclearwas.domains.course.domain.QCourseTime;
import com.allclearwas.domains.course.dto.request.CourseFilterRequest;
import com.allclearwas.domains.course.repository.QueryDslCourseRepository;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class QueryDslCourseRepositoryImpl implements QueryDslCourseRepository {

	private final JPAQueryFactory queryFactory;

	private final QCourse course = QCourse.course;
	private final QCourseInfo courseInfo = QCourseInfo.courseInfo;
	private final QCourseTime time1 = new QCourseTime("time1");
	private final QCourseTime time2 = new QCourseTime("time2");

	@Override
	public List<CourseListDao> findFilteredCourses(CourseFilterRequest request) {

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
			.select(Projections.constructor(CourseListDao.class,
				course.id,
				course.courseCode,
				course.name,
				course.professor,
				course.location,
				course.capacity,
				course.credit,

				JPAExpressions.select(
						Expressions.stringTemplate(
							"concat({0}, ' ', {1}, '~', {2})",
							time1.dayOfWeek.stringValue(),
							time1.startTime.stringValue(),
							time1.endTime.stringValue()
						)
					)
					.from(time1)
					.where(time1.course.eq(course))
					.orderBy(time1.id.asc())
					.limit(1),

				JPAExpressions.select(
						Expressions.stringTemplate(
							"concat({0}, ' ', {1}, '~', {2})",
							time2.dayOfWeek.stringValue(),
							time2.startTime.stringValue(),
							time2.endTime.stringValue()
						)
					)
					.from(time2)
					.where(time2.course.eq(course))
					.orderBy(time2.id.asc())
					.offset(1)
					.limit(1)
			))
			.from(course)
			.join(course.courseInfo, courseInfo)
			.where(builder)
			.fetch();
	}
}
