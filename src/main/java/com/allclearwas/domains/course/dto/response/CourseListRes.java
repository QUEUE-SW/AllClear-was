package com.allclearwas.domains.course.dto.response;

import com.allclearwas.domains.course.dao.CourseListDao;
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
	public static CourseListRes of(CourseListDao dao) {
		return new CourseListRes(
			dao.getCourseId(),
			dao.getCourseCode(),
			dao.getName(),
			dao.getProfessor(),
			dao.getLocation(),
			dao.getCapacity(),
			dao.getCredit(),
			dao.getTime1(),
			dao.getTime2()
		);
	}
}
