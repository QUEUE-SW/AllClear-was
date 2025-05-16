package com.allclearwas.domains.student.dto.response;

import com.allclearwas.domains.student.domain.StudentPolicy;

import io.swagger.v3.oas.annotations.media.Schema;

public record StudentCreditRes(
	@Schema(description = "현재 수강 중인 총 학점", example = "6")
	int totalCredit,
	@Schema(description = "최대 신청 가능 학점", example = "18")
	int maxCredit,
	@Schema(description = "남은 신청 가능 학점", example = "12")
	int remainingCredit
) {
	public static StudentCreditRes from(StudentPolicy studentPolicy) {
		return new StudentCreditRes(
			studentPolicy.getCurrentCredits(),
			studentPolicy.getMaxCredits(),
			studentPolicy.getMaxCredits() - studentPolicy.getCurrentCredits()
		);
	}
}
