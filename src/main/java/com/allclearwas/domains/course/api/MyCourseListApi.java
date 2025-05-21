package com.allclearwas.domains.course.api;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

import com.allclearwas.common.security.authentication.SecurityUserDetails;
import com.allclearwas.domains.course.dto.response.MyCourseListRes;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "수강신청 현황 조회 API")
public interface MyCourseListApi {

	@Operation(summary = "나의 수강 신청 목록 조회", description = "로그인한 학생이 자신이 신청한 강의 목록을 조회한다.")
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "강의 목록 조회 성공, 예시는 리스트의 한 항목입니다.",
			content = @Content(mediaType = "application/json",
				array = @ArraySchema(schema = @Schema(implementation = MyCourseListRes.class)))),
		@ApiResponse(responseCode = "404", description = "해당 학생이 존재하지 않음",
			content = @Content(mediaType = "application/json", examples = {
				@ExampleObject(name = "실패 예시", value = """
					{
					    "code": "4040",
					    "message": "해당 학생이 존재하지 않습니다.",
					    "errors": []
					}""")}))})
	ResponseEntity<?> getMyCourses(@AuthenticationPrincipal SecurityUserDetails userDetails);
}
