package com.allclearwas.domains.course.dao;

import com.allclearwas.domains.course.type.Location;
import com.allclearwas.domains.course.type.Professor;

public record MyCourseListDao(
	Long enrollmentId,
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
}
