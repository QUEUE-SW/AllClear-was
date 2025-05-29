package com.allclearwas.domains.enrollment.dto.response;

import com.allclearwas.domains.enrollment.dao.CourseEnrollmentCountDao;

public record CourseEnrollmentCountRes(
	Long courseId,
	Long current
) {
	public static CourseEnrollmentCountRes of(CourseEnrollmentCountDao dao) {
		return new CourseEnrollmentCountRes(dao.getCourseId(), dao.getCount());
	}
}
