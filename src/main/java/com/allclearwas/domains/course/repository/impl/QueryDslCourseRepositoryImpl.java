package com.allclearwas.domains.course.repository.impl;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.allclearwas.domains.course.dao.CourseListDao;
import com.allclearwas.domains.course.dao.MyCourseListDao;
import com.allclearwas.domains.course.domain.Course;
import com.allclearwas.domains.course.domain.CourseTime;
import com.allclearwas.domains.course.domain.QCourse;
import com.allclearwas.domains.course.domain.QCourseInfo;
import com.allclearwas.domains.course.domain.QCourseTime;
import com.allclearwas.domains.course.dto.request.CourseFilterReq;
import com.allclearwas.domains.course.repository.QueryDslCourseRepository;
import com.allclearwas.domains.enrollment.domain.Enrollment;
import com.allclearwas.domains.enrollment.domain.QEnrollment;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.SimpleExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class QueryDslCourseRepositoryImpl implements QueryDslCourseRepository {

	private final JPAQueryFactory queryFactory;
	private final QCourse course = QCourse.course;
	private final QCourseInfo courseInfo = QCourseInfo.courseInfo;
	private final QEnrollment enrollment = QEnrollment.enrollment;
	private final QCourseTime courseTime = QCourseTime.courseTime;

	@Override
	public List<CourseListDao> findFilteredCourses(CourseFilterReq request) {

		List<Tuple> tuples = queryFactory
			.select(course, courseTime)
			.from(course)
			.leftJoin(courseTime).on(courseTime.course.eq(course))
			.join(course.courseInfo, courseInfo)
			.where(equalsIfNotNull(courseInfo.category, request.category()),
				equalsIfNotNull(courseInfo.grade, request.grade()),
				equalsIfNotNull(courseInfo.department, request.department()),
				equalsIfNotNull(courseInfo.major, request.major()))
			.fetch();

		Map<Course, List<CourseTime>> grouped = tuples.stream()
			.filter(t -> t.get(course) != null)
			.collect(Collectors.groupingBy(
				t -> t.get(course),
				LinkedHashMap::new,
				Collectors.mapping(t -> t.get(courseTime), Collectors.toList())
			));

		return grouped.entrySet().stream()
			.map(entry -> toCourseListDao(entry.getKey(), entry.getValue()))
			.toList();
	}

	@Override
	public List<MyCourseListDao> findMyCourses(Long studentId) {
		List<Tuple> tuples = queryFactory
			.select(enrollment, course, courseTime)
			.from(enrollment)
			.join(enrollment.course, course)
			.leftJoin(courseTime).on(courseTime.course.eq(course))
			.where(enrollment.student.id.eq(studentId))
			.fetch();

		Map<Course, List<CourseTime>> grouped = tuples.stream()
			.filter(t -> t.get(course) != null)
			.collect(Collectors.groupingBy(
				t -> t.get(course),
				LinkedHashMap::new,
				Collectors.mapping(t -> t.get(courseTime), Collectors.toList())
			));

		return grouped.entrySet().stream()
			.map(entry -> {
				Enrollment e = tuples.stream()
					.filter(t -> t.get(course).equals(entry.getKey()))
					.map(t -> t.get(enrollment))
					.findFirst()
					.orElse(null);
				return toMyCourseListDao(e, entry.getKey(), entry.getValue());
			})
			.toList();
	}

	private CourseListDao toCourseListDao(Course c, List<CourseTime> times) {
		String time1 = formatTime(times, 0);
		String time2 = formatTime(times, 1);
		return new CourseListDao(
			c.getId(),
			c.getCourseCode(),
			c.getName(),
			c.getProfessor(),
			c.getLocation(),
			c.getCapacity(),
			c.getCredit(),
			time1,
			time2
		);
	}

	private MyCourseListDao toMyCourseListDao(Enrollment e, Course c, List<CourseTime> times) {
		String time1 = formatTime(times, 0);
		String time2 = formatTime(times, 1);
		return new MyCourseListDao(
			e.getId(),
			c.getId(),
			c.getCourseCode(),
			c.getName(),
			c.getProfessor(),
			c.getLocation(),
			c.getCapacity(),
			c.getCredit(),
			time1,
			time2
		);
	}

	private <T> BooleanExpression equalsIfNotNull(SimpleExpression<T> path, T value) {
		return value != null ? path.eq(value) : null;
	}

	private String formatTime(List<CourseTime> times, int index) {
		if (times.size() > index) {
			CourseTime t = times.get(index);
			return dayOfWeekToKorean(t.getDayOfWeek()) + " " + formatTimeRange(t.getStartTime(), t.getEndTime());
		}
		return null;
	}

	private String formatTimeRange(LocalTime start, LocalTime end) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
		return start.format(formatter) + "~" + end.format(formatter);
	}

	private String dayOfWeekToKorean(DayOfWeek dayOfWeek) {
		return switch (dayOfWeek) {
			case MONDAY -> "월";
			case TUESDAY -> "화";
			case WEDNESDAY -> "수";
			case THURSDAY -> "목";
			case FRIDAY -> "금";
			case SATURDAY -> "토";
			case SUNDAY -> "일";
		};
	}
}
