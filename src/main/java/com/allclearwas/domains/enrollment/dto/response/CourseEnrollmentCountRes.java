package com.allclearwas.domains.enrollment.dto.response;

public record CourseEnrollmentCountRes(
	Long courseId,
	int participant
) {
}
