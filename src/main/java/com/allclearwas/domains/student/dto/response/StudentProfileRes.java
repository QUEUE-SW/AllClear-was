package com.allclearwas.domains.student.dto.response;

import com.allclearwas.domains.student.domain.Student;
import com.allclearwas.domains.student.domain.StudentPolicy;

public record StudentProfileRes(
	String name,
	String identifier,
	String semester
) {
	public static StudentProfileRes from(Student student, StudentPolicy studentPolicy) {
		return new StudentProfileRes(
			student.getName(),
			student.getIdentifier(),
			studentPolicy.getSemester().getName()
		);
	}
}
