package com.allclearwas.domains.student.implement;

import java.util.Optional;

import com.allclearwas.common.annotation.Implementation;
import com.allclearwas.domains.student.domain.StudentPolicy;
import com.allclearwas.domains.student.repository.StudentPolicyRepository;

import lombok.RequiredArgsConstructor;

@Implementation
@RequiredArgsConstructor
public class StudentPolicyReader {

	private final StudentPolicyRepository studentPolicyRepository;

	public Optional<StudentPolicy> read(Long studentId) {
		return studentPolicyRepository.findById(studentId);
	}
}
