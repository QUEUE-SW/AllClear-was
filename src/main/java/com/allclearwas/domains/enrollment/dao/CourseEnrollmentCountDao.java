package com.allclearwas.domains.enrollment.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CourseEnrollmentCountDao {
	private Long courseId;
	private Long count;
}
