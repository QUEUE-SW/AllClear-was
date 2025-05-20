package com.allclearwas.domains.course.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.allclearwas.domains.course.domain.CourseTime;

public interface CourseTimeRepository extends JpaRepository<CourseTime, Long> {

	List<CourseTime> findByCourseId(Long courseId);

	@Query("""
		    SELECT ct FROM CourseTime ct
		    WHERE ct.course.id IN :courseIds
		""")
	List<CourseTime> findByCourseIds(@Param("courseIds") List<Long> courseIds);
}
