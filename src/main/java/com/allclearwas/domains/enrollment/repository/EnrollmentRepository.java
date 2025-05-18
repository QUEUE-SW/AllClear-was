package com.allclearwas.domains.enrollment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.allclearwas.domains.enrollment.domain.Enrollment;
import com.allclearwas.domains.enrollment.dto.EnrolledCountRes;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {

	@Query("SELECT new com.allclearwas.domains.enrollment.dto.EnrolledCountRes(e.course.id, COUNT(e)) "
		+ "FROM Enrollment e WHERE e.course.id IN :courseIds GROUP BY e.course.id")
	List<EnrolledCountRes> countByCourseIds(@Param("courseIds") List<Long> courseIds);
}
