package com.allclearwas.domains.course.dto.response;

import com.allclearwas.domains.course.dao.MyCourseListDao;
import com.allclearwas.domains.course.type.Location;
import com.allclearwas.domains.course.type.Professor;

public record MyCourseListRes(
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
	public static MyCourseListRes of(MyCourseListDao dao) {
		return new MyCourseListRes(
			dao.enrollmentId(),
			dao.courseId(),
			dao.courseCode(),
			dao.name(),
			dao.professor(),
			dao.location(),
			dao.capacity(),
			dao.credit(),
			dao.time1(),
			dao.time2()
		);
	}
}
