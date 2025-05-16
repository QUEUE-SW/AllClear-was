package com.allclearwas.domains.course.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.allclearwas.domains.course.domain.CourseTime;

public interface CourseTimeRepository extends JpaRepository<CourseTime, Long> {

	List<CourseTime> findByCourseId(Long courseId);
}
