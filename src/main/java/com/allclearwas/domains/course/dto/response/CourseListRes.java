package com.allclearwas.domains.course.dto.response;

import com.allclearwas.domains.course.domain.Course;
import com.allclearwas.domains.course.type.Location;
import com.allclearwas.domains.course.type.Professor;

public record CourseListRes(
	Long courseId,
	String courseCode,
	String name,
	Professor professor,
	Location location,
	int capacity,
	int credit,
	String time1,
	String time2
) {
	public static CourseListRes of(
		Course course,
		String time1,
		String time2
	) {
		return new CourseListRes(
			course.getId(),
			course.getCourseCode(),
			course.getName(),
			course.getProfessor(),
			course.getLocation(),
			course.getCapacity(),
			course.getCredit(),
			time1,
			time2
		);
	}
}
