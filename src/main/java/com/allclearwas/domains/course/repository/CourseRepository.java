package com.allclearwas.domains.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.allclearwas.domains.course.domain.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
}

