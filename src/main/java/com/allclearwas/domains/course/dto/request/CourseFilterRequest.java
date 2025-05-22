package com.allclearwas.domains.course.dto.request;

import com.allclearwas.domains.course.type.Category;
import com.allclearwas.domains.student.type.Department;

import io.swagger.v3.oas.annotations.media.Schema;

public record CourseFilterRequest(
	@Schema(description = "이수구분", example = "전공") Category category,
	@Schema(description = "학년", example = "2") Integer grade,
	@Schema(description = "학과", example = "컴퓨터공학부") Department department,
	@Schema(description = "강의코드", example = "CS101") String code
) {
}
