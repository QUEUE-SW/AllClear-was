package com.allclearwas.domains.student.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.allclearwas.common.exception.GlobalException;
import com.allclearwas.common.exception.student.StudentErrorCode;
import com.allclearwas.domains.student.domain.Student;
import com.allclearwas.domains.student.dto.response.StudentInfoResponse;
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

	public StudentInfoResponse getStudentInfo(Long studentId) {
		Student student = studentRepository.findById(studentId)
			.orElseThrow(() -> new GlobalException(StudentErrorCode.STUDENT_NOT_FOUND));

		return new StudentInfoResponse(
			student.getName(),
			student.getIdentifier(),
			student.getStudentPolicy().getSemester()
		);
	}
}
