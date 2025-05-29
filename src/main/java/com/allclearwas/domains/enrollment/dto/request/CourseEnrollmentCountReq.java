package com.allclearwas.domains.enrollment.dto.request;

import java.util.List;

public record CourseEnrollmentCountReq(
	List<Long> ids
) {
}
