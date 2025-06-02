package com.allclearwas.domains.course.dto.request;

import com.allclearwas.domains.course.type.Category;
import com.allclearwas.domains.student.type.Department;
import com.allclearwas.domains.student.type.Major;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public record CourseFilterReq(
	@Schema(description = "이수구분", example = "전공") Category category,

	@Min(value = 1, message = "학년은 1학년 이상이어야 합니다.")
	@Max(value = 4, message = "학년은 4학년 이하여야 합니다.")
	@Schema(description = "학년", example = "2") Integer grade,

	@Schema(description = "학과", example = "컴퓨터학부") Department department,
	@Schema(description = "전공", example = "컴퓨터공학전공") Major major
) {
}
