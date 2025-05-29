package com.allclearwas.domains.course.dto.response;

import com.allclearwas.domains.course.dao.MyCourseListDao;

public record MyCourseListRes(
	Long enrollmentId,
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
	public static MyCourseListRes of(MyCourseListDao dao) {
		return new MyCourseListRes(
			dao.getEnrollmentId(),
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
