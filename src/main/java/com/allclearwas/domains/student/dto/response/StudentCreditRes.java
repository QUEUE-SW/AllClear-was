package com.allclearwas.domains.student.dto.response;

import com.allclearwas.domains.student.domain.StudentPolicy;

public record StudentCreditRes(
	int totalCredit,
	int maxCredit,
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
