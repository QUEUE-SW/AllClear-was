package com.allclearwas.domains.course.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.allclearwas.domains.course.domain.Course;
import com.allclearwas.domains.enrollment.dto.response.CourseEnrollmentCountRes;

public interface CourseRepository extends JpaRepository<Course, Long>, QueryDslCourseRepository {

	@Query("SELECT new com.allclearwas.domains.enrollment.dto.response.CourseEnrollmentCountRes(c.id, c.participant) "
		+ "FROM Course c WHERE c.id IN :courseIds")
	List<CourseEnrollmentCountRes> findParticipantsByCourseIds(@Param("courseIds") List<Long> courseIds);
}

