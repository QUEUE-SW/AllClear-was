package com.allclearwas.domains.enrollment.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public record EnrolledCountRes(
	@Schema(description = "강의 ID", example = "1")
	Long courseId,
	@Schema(description = "현재 수강신청된 자리 수", example = "21")
	int current
) {
	public static EnrolledCountRes of(Long courseId, int current) {
		return new EnrolledCountRes(courseId, current);
	}
}
