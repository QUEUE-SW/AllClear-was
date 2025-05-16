package com.allclearwas.domains.student.api;

import org.springframework.http.ResponseEntity;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "학생 기본정보 조회 API")
public interface StudentProfileApi {

	@Operation(
		summary = "학생 기본정보 조회",
		description = "로그인한 학생의 이름, 학번, 학기를 조회합니다.",
		security = {@SecurityRequirement(name = "JWT")}
	)
	@ApiResponses(value = {
		@ApiResponse(responseCode = "2000", description = "학생 정보 조회 성공",
			content = @Content(mediaType = "application/json", examples = {
				@ExampleObject(name = "성공 예시", value = """
					{
					    "code": "2000",
					    "message": "요청에 성공하였습니다.",
					    "data": {
					        "name": "홍길동",
					        "identifier": 12345678,
					        "semester": "1학기"
					    }
					}
					""")
			})),
		@ApiResponse(responseCode = "404", description = "해당 학생이 존재하지 않음",
			content = @Content(mediaType = "application/json", examples = {
				@ExampleObject(name = "실패 예시", value = """
					{
					    "code": "4040",
					    "message": "해당 학생이 존재하지 않습니다.",
					    "errors": []
					}
					""")
			}))
	})
	ResponseEntity<?> getStudentProfile();
}
