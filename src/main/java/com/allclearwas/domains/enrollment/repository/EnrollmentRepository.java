package com.allclearwas.domains.enrollment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.allclearwas.domains.enrollment.domain.Enrollment;
import com.allclearwas.domains.student.domain.Student;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {

	List<Enrollment> findByStudent(Student student);
}
