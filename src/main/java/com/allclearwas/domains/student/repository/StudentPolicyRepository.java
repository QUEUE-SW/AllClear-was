package com.allclearwas.domains.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.allclearwas.domains.student.domain.StudentPolicy;

public interface StudentPolicyRepository extends JpaRepository<StudentPolicy, Long> {
}
