package com.allclearwas.domains.student.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "학생 학점정보 조회 API")
public interface StudentPolicyApi {

	@Operation(
		summary = "학생 학점정보 조회",
		description = "로그인한 학생의 현재 수강 중인 총 학점, 최대 신청 가능 학점, 남은 신청 가능 학점을 조회합니다.",
		security = {@SecurityRequirement(name = "JWT")}
	)
	@ApiResponses(value = {
		@ApiResponse(responseCode = "2000", description = "학생 학점정보 조회 성공",
			content = @Content(mediaType = "application/json", examples = {
				@ExampleObject(name = "성공 예시", value = """
					{
					    "code": "2000",
					    "message": "요청에 성공하였습니다.",
					    "data": {
					        "totalCredit": 6,
					        "maxCredit": 18,
					        "remainingCredit": 12
					    }
					}
					""")
			})),
		@ApiResponse(responseCode = "403", description = "JWT 인증 실패",
			content = @Content(mediaType = "application/json", examples = {
				@ExampleObject(name = "인증 실패", value = """
					{
					    "code": "4030",
					    "message": "JWT 인증에 실패하였습니다.",
					    "errors": []
					}
					""")
			}))
	})
	@GetMapping("/api/v1/student_polices/credits")
	ResponseEntity<?> getStudentProfile();
}
