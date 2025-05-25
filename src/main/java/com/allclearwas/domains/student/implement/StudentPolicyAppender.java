package com.allclearwas.domains.student.implement;

import com.allclearwas.common.annotation.Implementation;
import com.allclearwas.domains.student.domain.StudentPolicy;
import com.allclearwas.domains.student.repository.StudentPolicyRepository;

import lombok.RequiredArgsConstructor;

@Implementation
@RequiredArgsConstructor
public class StudentPolicyAppender {

	private final StudentPolicyRepository studentPolicyRepository;

	public void append(StudentPolicy studentPolicy) {
		studentPolicyRepository.save(studentPolicy);
	}
}
