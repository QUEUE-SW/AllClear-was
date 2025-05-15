package com.allclearwas.domains.student.implement;

import java.util.Optional;

import com.allclearwas.common.annotation.Implementation;
import com.allclearwas.domains.student.domain.Student;
import com.allclearwas.domains.student.repository.StudentRepository;

import lombok.RequiredArgsConstructor;

@Implementation
@RequiredArgsConstructor
public class StudentReader {

	private final StudentRepository studentRepository;

	public Optional<Student> read(Long studentId) {
		return studentRepository.findById(studentId);
	}

	public Optional<Student> readByIdentifier(int identifier) {
		return studentRepository.findByIdentifier(identifier);
	}
}
