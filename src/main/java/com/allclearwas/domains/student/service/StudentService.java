package com.allclearwas.domains.student.service;

import org.springframework.stereotype.Service;

import com.allclearwas.common.exception.student.StudentErrorCode;
import com.allclearwas.common.exception.student.StudentException;
import com.allclearwas.domains.student.domain.Student;
import com.allclearwas.domains.student.domain.StudentPolicy;
import com.allclearwas.domains.student.dto.response.StudentCreditRes;
import com.allclearwas.domains.student.dto.response.StudentProfileRes;
import com.allclearwas.domains.student.implement.StudentPolicyAppender;
import com.allclearwas.domains.student.implement.StudentPolicyReader;
import com.allclearwas.domains.student.implement.StudentReader;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentService {

	private final StudentReader studentReader;
	private final StudentPolicyAppender studentPolicyAppender;
	private final StudentPolicyReader studentPolicyReader;

	public StudentProfileRes getStudentInfo(Long studentId) {
		Student student = studentReader.read(studentId)
			.orElseThrow(() -> new StudentException(StudentErrorCode.STUDENT_NOT_FOUND));

		StudentPolicy studentPolicy = studentPolicyReader.read(studentId)
			.orElseThrow(() -> new StudentException(StudentErrorCode.STUDENT_POLICY_NOT_FOUND));

		return StudentProfileRes.from(student, studentPolicy);
	}

	public StudentCreditRes getStudentPolicyInfo(Long studentId) {
		StudentPolicy studentPolicy = studentPolicyReader.read(studentId)
			.orElseThrow(() -> new StudentException(StudentErrorCode.STUDENT_POLICY_NOT_FOUND));

		return StudentCreditRes.from(studentPolicy);
	}

	public void initStudentPolicy(Student student) {
		StudentPolicy studentPolicy = StudentPolicy.of(student);
		studentPolicyAppender.append(studentPolicy);
	}
}
