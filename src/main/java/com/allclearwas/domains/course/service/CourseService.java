package com.allclearwas.domains.course.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.allclearwas.domains.course.domain.Course;
import com.allclearwas.domains.course.domain.CourseTime;
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

	public List<CourseListRes> getCourseList() {
		List<Course> courses = courseReader.findAllCourses();

		return courses.stream()
			.map(course -> {
				List<CourseTime> times = courseReader.findCourseTimesByCourseId(course.getId());

				String time1 = CourseTimeFormatter.formatTime(times, 0);
				String time2 = CourseTimeFormatter.formatTime(times, 1);

				return CourseListRes.of(course, time1, time2);
			})
			.toList();
	}

	public List<MyCourseListRes> getMyCourses(Long studentId) {

		List<Enrollment> enrollments = enrollmentReader.findEnrollmentsWithCourseAndTimes(studentId);

		return enrollments.stream()
			.map(enrollment -> {
				Course course = enrollment.getCourse();
				List<CourseTime> times = course.getCourseTimes();

				String time1 = CourseTimeFormatter.formatTime(times, 0);
				String time2 = CourseTimeFormatter.formatTime(times, 1);

				return MyCourseListRes.of(enrollment.getId(), course, time1, time2);
			})
			.toList();
	}
}
