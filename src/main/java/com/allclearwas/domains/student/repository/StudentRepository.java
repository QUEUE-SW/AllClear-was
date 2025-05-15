package com.allclearwas.domains.student.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.allclearwas.domains.student.domain.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

	Optional<Student> findByIdentifier(int identifier);
}
