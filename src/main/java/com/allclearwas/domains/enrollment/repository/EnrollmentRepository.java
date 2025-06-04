package com.allclearwas.domains.enrollment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.allclearwas.domains.enrollment.domain.Enrollment;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
}
