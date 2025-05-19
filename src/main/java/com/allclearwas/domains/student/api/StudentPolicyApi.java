package com.allclearwas.domains.student.api;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

import com.allclearwas.common.security.authentication.SecurityUserDetails;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "학생 학점정보 조회 API")
public interface StudentPolicyApi {

	@Operation(
		summary = "학생 학점정보 조회",
		description = "로그인한 학생의 현재 수강 중인 총 학점, 최대 신청 가능 학점, 남은 신청 가능 학점을 조회합니다."
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
		@ApiResponse(responseCode = "404", description = "해당 학생 정책이 존재하지 않음",
			content = @Content(mediaType = "application/json", examples = {
				@ExampleObject(name = "실패 예시", value = """
					{
					    "code": "4040",
					    "message": "해당 학생 정책이 존재하지 않습니다.",
					    "errors": []
					}
					""")
			}))
	})
	ResponseEntity<?> getStudentPolicyInfo(@AuthenticationPrincipal SecurityUserDetails userDetails);
}
