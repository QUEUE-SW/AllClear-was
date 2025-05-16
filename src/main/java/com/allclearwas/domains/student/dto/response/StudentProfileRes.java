package com.allclearwas.domains.student.dto.response;

import com.allclearwas.domains.student.domain.Student;
import com.allclearwas.domains.student.domain.StudentPolicy;
import com.allclearwas.domains.student.type.Semester;

import io.swagger.v3.oas.annotations.media.Schema;

public record StudentProfileRes(
	@Schema(description = "학생 이름", example = "박지원")
	String name,
	@Schema(description = "학번 (고유 ID)", example = "22012077")
	int studentId,
	@Schema(description = "현재 학기", example = "1학기")
	Semester semester
) {
	public static StudentProfileRes from(Student student, StudentPolicy studentPolicy) {
		return new StudentProfileRes(
			student.getName(),
			student.getIdentifier(),
			studentPolicy.getSemester()
		);
	}
}
