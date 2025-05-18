package com.allclearwas.domains.enrollment.api;

import org.springframework.http.ResponseEntity;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "강의 수강 신청 인원 조회 API")
public interface EnrollmentApi {

	@Operation(
		summary = "강의 남은 자리 수 조회",
		description = "개설된 강의 목록의 현재 찬 자리 수 모두 조회합니다."
	)
	@ApiResponses(value = {
		@ApiResponse(responseCode = "2000", description = "강의 남은 자리수 조회 성공",
			content = @Content(mediaType = "application/json", examples = {
				@ExampleObject(name = "성공 예시", value = """
					{
					    "code": "2000",
					    "message": "요청에 성공하였습니다.",
					    "data": [
					      { "courseId": 1, "current": 21},
					      { "courseId": 2, "current": 15},
					       ...
					    ]
					}
					""")
			}))
	})
	ResponseEntity<?> getEnrolledCount();
}
