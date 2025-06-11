package com.allclearwas.domains.enrollment.dto.response;

import com.allclearwas.domains.enrollment.domain.Enrollment;

public record EnrollmentRes(
	Long enrollmentId,
	Long courseId,
	String courseName
) {
	public static EnrollmentRes of(Enrollment enrollment) {
		return new EnrollmentRes(
			enrollment.getId(),
			enrollment.getCourse().getId(),
			enrollment.getCourse().getName()
		);
	}
}
