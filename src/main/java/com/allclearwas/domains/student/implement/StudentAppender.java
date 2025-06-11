package com.allclearwas.domains.student.implement;

import com.allclearwas.common.annotation.Implementation;
import com.allclearwas.domains.student.domain.Student;
import com.allclearwas.domains.student.repository.StudentRepository;

import lombok.RequiredArgsConstructor;

@Implementation
@RequiredArgsConstructor
public class StudentAppender {

	private final StudentRepository studentRepository;

	public void append(Student student) {
		studentRepository.save(student);
	}
}

