package com.allclearwas.domains.course.dto.response;

import com.allclearwas.domains.course.dao.CourseListDao;

public record CourseListRes(
	Long courseId,
	String courseCode,
	String name,
	String professor,
	String location,
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
			dao.getProfessor().getName(),
			dao.getLocation().getName(),
			dao.getCapacity(),
			dao.getCredit(),
			dao.getTime1(),
			dao.getTime2()
		);
	}
}
