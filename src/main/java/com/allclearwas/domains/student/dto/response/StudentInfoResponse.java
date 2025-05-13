package com.allclearwas.domains.student.dto.response;

import com.allclearwas.domains.student.type.Semester;

public record StudentInfoResponse(
	String name,
	int studentId,
	Semester semester
) {
}
