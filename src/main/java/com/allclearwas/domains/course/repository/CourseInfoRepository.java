package com.allclearwas.domains.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.allclearwas.domains.course.domain.CourseInfo;

public interface CourseInfoRepository extends JpaRepository<CourseInfo, Long> {
}
