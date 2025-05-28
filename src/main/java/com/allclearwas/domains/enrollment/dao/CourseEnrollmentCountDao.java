package com.allclearwas.domains.enrollment.dao;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CourseEnrollmentCountDao {
	private Long courseId;
	private int count;
}
