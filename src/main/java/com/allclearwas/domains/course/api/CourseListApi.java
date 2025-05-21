package com.allclearwas.domains.course.api;

import org.springframework.http.ResponseEntity;

import com.allclearwas.domains.course.dto.response.CourseListRes;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "모든 강의 조회 API")
public interface CourseListApi {

	@Operation(
		summary = "모든 강의정보 조회",
		description = "개설된 모든 강의 목록을 조회한다."
	)
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "강의 목록 조회 성공, 예시는 리스트의 한 항목입니다.",
			content = @Content(mediaType = "application/json",
				array = @ArraySchema(schema = @Schema(implementation = CourseListRes.class))))}
	)
	ResponseEntity<?> getCourseList();
}
