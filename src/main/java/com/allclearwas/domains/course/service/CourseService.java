package com.allclearwas.domains.course.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.allclearwas.domains.course.domain.Course;
import com.allclearwas.domains.course.domain.CourseTime;
import com.allclearwas.domains.course.dto.response.CourseListRes;
import com.allclearwas.domains.course.implement.CourseReader;
import com.allclearwas.domains.course.support.CourseTimeFormatter;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CourseService {

	private final CourseReader courseReader;

	private static final String SPACE = " ";
	private static final String TILDE = "~";

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
}
