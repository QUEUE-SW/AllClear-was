package com.allclearwas.domains.enrollment.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

public record EnrollmentReq(
	@Schema(description = "강의 ID", example = "2") Long courseId
) {
}
