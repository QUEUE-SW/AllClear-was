package com.allclearwas.domains.enrollment.dto;

public record CourseEnrollmentCountDto(
	Long courseId,
	int current
) {
	public static CourseEnrollmentCountDto of(Long courseId, int current) {
		return new CourseEnrollmentCountDto(courseId, current);
	}
}
