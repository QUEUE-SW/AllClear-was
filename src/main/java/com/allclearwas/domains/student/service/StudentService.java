package com.allclearwas.domains.student.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.allclearwas.domains.student.domain.Student;
import com.allclearwas.domains.student.repository.StudentRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class StudentService {

	private final StudentRepository studentRepository;

	public Optional<Student> readStudent(Long studentId) {
		return studentRepository.findById(studentId);
	}
}
