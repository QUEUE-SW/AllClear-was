package com.allclearwas.domains.course.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.allclearwas.domains.course.dao.CourseListDao;
import com.allclearwas.domains.course.domain.QCourse;
import com.allclearwas.domains.course.domain.QCourseInfo;
import com.allclearwas.domains.course.domain.QCourseTime;
import com.allclearwas.domains.course.dto.request.CourseFilterReq;
import com.allclearwas.domains.course.repository.QueryDslCourseRepository;
import com.querydsl.core.types.Expression;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.SimpleExpression;
import com.querydsl.core.types.dsl.StringExpression;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class QueryDslCourseRepositoryImpl implements QueryDslCourseRepository {

	private final JPAQueryFactory queryFactory;
	private final QCourse course = QCourse.course;
	private final QCourseInfo courseInfo = QCourseInfo.courseInfo;

	@Override
	public List<CourseListDao> findFilteredCourses(CourseFilterReq request) {

		QCourseTime time1 = new QCourseTime("time1");
		QCourseTime time2 = new QCourseTime("time2");

		return queryFactory
			.select(Projections.constructor(CourseListDao.class,
				course.id,
				course.courseCode,
				course.name,
				course.professor,
				course.location,
				course.capacity,
				course.credit,
				selectTimeString(time1, course, 0),
				selectTimeString(time2, course, 1)
			))
			.from(course)
			.join(course.courseInfo, courseInfo)
			.where(equalsIfNotNull(courseInfo.category, request.category()),
				equalsIfNotNull(courseInfo.grade, request.grade()),
				equalsIfNotNull(courseInfo.department, request.department()),
				equalsIfNotBlank(course.courseCode, request.code()))
			.fetch();
	}

	private <T> BooleanExpression equalsIfNotNull(SimpleExpression<T> path, T value) {
		return value != null ? path.eq(value) : null;
	}

	private BooleanExpression equalsIfNotBlank(StringExpression path, String value) {
		return value != null && !value.isBlank() ? path.eq(value) : null;
	}

	private Expression<String> selectTimeString(QCourseTime time, QCourse course, int offset) {
		return JPAExpressions.select(
				Expressions.stringTemplate(
					"concat({0}, ' ', {1}, '~', {2})",
					time.dayOfWeek.stringValue(),
					time.startTime.stringValue(),
					time.endTime.stringValue()
				)
			)
			.from(time)
			.where(time.course.eq(course))
			.orderBy(time.id.asc())
			.offset(offset)
			.limit(1);
	}
}
