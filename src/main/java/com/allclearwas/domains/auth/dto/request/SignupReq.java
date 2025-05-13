package com.allclearwas.domains.auth.dto.request;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.allclearwas.domains.student.domain.Student;
import com.allclearwas.domains.student.type.College;
import com.allclearwas.domains.student.type.Department;
import com.allclearwas.domains.student.type.Major;

public record SignupReq(
	int identifier,
	String password,
	String name,
	int grade,
	College college,
	Department department,
	Major major
) {

	public Student toEntity(PasswordEncoder passwordEncoder) {
		return Student.builder()
			.identifier(identifier)
			.password(passwordEncoder.encode(password))
			.name(name)
			.grade(grade)
			.college(college)
			.department(department)
			.major(major)
			.build();
	}
}
