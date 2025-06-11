package com.allclearwas.domains.enrollment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.allclearwas.domains.enrollment.domain.Enrollment;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long>, QueryDslEnrollmentRepository {

	boolean existsByStudentIdAndCourseId(Long studentId, Long courseId);

	boolean existsByStudentIdAndCourse_Name(Long studentId, String courseName);
}
