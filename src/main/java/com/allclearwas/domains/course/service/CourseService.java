package com.allclearwas.domains.course.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.allclearwas.domains.course.domain.Course;
import com.allclearwas.domains.course.domain.CourseTime;
import com.allclearwas.domains.course.dto.request.CourseFilterReq;
import com.allclearwas.domains.course.dto.response.CourseListRes;
import com.allclearwas.domains.course.dto.response.MyCourseListRes;
import com.allclearwas.domains.course.implement.CourseReader;
import com.allclearwas.domains.course.support.CourseTimeFormatter;
import com.allclearwas.domains.enrollment.domain.Enrollment;
import com.allclearwas.domains.enrollment.implement.EnrollmentReader;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CourseService {

	private final CourseReader courseReader;
	private final EnrollmentReader enrollmentReader;

	public List<CourseListRes> getfilterCourses(CourseFilterReq request) {
		return courseReader.findFilteredCourses(request).stream()
			.map(CourseListRes::of)
			.toList();
	}

	public List<MyCourseListRes> getMyCourses(Long studentId) {

		List<Enrollment> enrollments = enrollmentReader.findEnrollmentsWithCourseAndTimes(studentId);

		List<Long> courseIds = enrollments.stream()
			.map(e -> e.getCourse().getId())
			.distinct()
			.toList();

		List<CourseTime> courseTimes = courseReader.findByCourseId(courseIds);

		Map<Long, List<CourseTime>> courseTimeMap = courseTimes.stream()
			.collect(Collectors.groupingBy(ct -> ct.getCourse().getId()));

		return enrollments.stream()
			.map(enrollment -> {
				Course course = enrollment.getCourse();
				List<CourseTime> times = courseTimeMap.getOrDefault(course.getId(), List.of());

				String time1 = CourseTimeFormatter.formatTime(times, 0);
				String time2 = CourseTimeFormatter.formatTime(times, 1);

				return MyCourseListRes.of(enrollment.getId(), course, time1, time2);
			})
			.toList();
	}
}
