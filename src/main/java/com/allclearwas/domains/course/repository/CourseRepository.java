package com.allclearwas.domains.course.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.allclearwas.domains.course.domain.Course;
import com.allclearwas.domains.enrollment.dto.response.CourseEnrollmentCountRes;

import jakarta.persistence.LockModeType;

public interface CourseRepository extends JpaRepository<Course, Long>, QueryDslCourseRepository {

	@Query("SELECT new com.allclearwas.domains.enrollment.dto.response.CourseEnrollmentCountRes(c.id, c.participant) "
		+ "FROM Course c WHERE c.id IN :courseIds")
	List<CourseEnrollmentCountRes> findParticipantsByCourseIds(@Param("courseIds") List<Long> courseIds);

	@Lock(LockModeType.PESSIMISTIC_WRITE)
	@Query("SELECT c FROM Course c WHERE c.id = :courseId")
	Optional<Course> findWithPessimisticLock(@Param("courseId") Long courseId);
}

