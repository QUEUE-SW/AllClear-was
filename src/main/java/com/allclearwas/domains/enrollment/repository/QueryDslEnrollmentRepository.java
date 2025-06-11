package com.allclearwas.domains.enrollment.repository;

public interface QueryDslEnrollmentRepository {

	boolean existsOverlappingTime(Long studentId, Long courseId);
}
