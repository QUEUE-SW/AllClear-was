package com.allclearwas.common.exception.student;

import com.allclearwas.common.exception.GlobalException;

import lombok.Getter;

@Getter
public class StudentException extends GlobalException {

	public StudentException(StudentErrorCode studentErrorCode) {
		super(studentErrorCode);
	}
}
