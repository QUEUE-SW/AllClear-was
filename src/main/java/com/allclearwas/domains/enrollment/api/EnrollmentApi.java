package com.allclearwas.domains.enrollment.api;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestBody;

import com.allclearwas.common.security.authentication.SecurityUserDetails;
import com.allclearwas.domains.enrollment.dto.request.EnrollmentReq;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "수강 신청 API")
public interface EnrollmentApi {

	@Operation(
		summary = "수강 신청",
		description = "현재 로그인한 학생이 특정 강의를 수강 신청합니다."
	)
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "수강 신청 성공",
			content = @Content(mediaType = "application/json", examples = {
				@ExampleObject(name = "성공 예시", value = """
					{
					    "code": "2000",
					    "message": "요청에 성공하였습니다.",
					    "data": {
					        "enrollmentId": 6,
					        "courseId": 2,
					        "courseName": "대학생활설계"
					    }
					}
					""")
			})),
		@ApiResponse(responseCode = "4091", description = "이미 신청한 강의임",
			content = @Content(mediaType = "application/json", examples = {
				@ExampleObject(name = "실패 예시", value = """
					{
					    "code": "4091",
					    "message": "이미 신청한 강의입니다.",
					    "errors": []
					}
					""")
			})),
		@ApiResponse(responseCode = "4040", description = "해당 강의가 존재하지 않음",
			content = @Content(mediaType = "application/json", examples = {
				@ExampleObject(name = "실패 예시", value = """
					{
					    "code": "4040",
					    "message": "수강 신청 정보를 찾을 수 없습니다.",
					    "errors": []
					}
					""")
			})),
		@ApiResponse(responseCode = "4090", description = "최대 학점 초과",
			content = @Content(mediaType = "application/json", examples = {
				@ExampleObject(name = "실패 예시", value = """
					{
					    "code": "4090",
					    "message": "최대 신청 학점을 초과했습니다.",
					    "errors": []
					}
					""")
			}))
	})
	ResponseEntity<?> enrollCourse(
		@RequestBody EnrollmentReq request,
		@AuthenticationPrincipal SecurityUserDetails userDetails
	);
}

