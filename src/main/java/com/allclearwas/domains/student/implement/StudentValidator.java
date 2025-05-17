package com.allclearwas.domains.student.implement;

import com.allclearwas.common.annotation.Implementation;
import com.allclearwas.common.exception.student.StudentErrorCode;
import com.allclearwas.common.exception.student.StudentException;

import lombok.RequiredArgsConstructor;

@Implementation
@RequiredArgsConstructor
public class StudentValidator {

	private final StudentReader studentReader;

	public void checkDuplicateStudent(String identifier) {
		studentReader.readByIdentifier(identifier)
			.ifPresent(student -> {
				throw new StudentException(StudentErrorCode.STUDENT_IS_DUPLICATED);
			});
	}
}
