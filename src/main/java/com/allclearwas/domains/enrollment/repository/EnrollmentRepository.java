package com.allclearwas.domains.enrollment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.allclearwas.domains.enrollment.domain.Enrollment;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {

	@Query("""
		   	 SELECT DISTINCT e FROM Enrollment e
		   	 JOIN FETCH e.course c
		      WHERE e.student.id = :studentId
		""")
	List<Enrollment> findWithCourseByStudentId(@Param("studentId") Long studentId);
}
