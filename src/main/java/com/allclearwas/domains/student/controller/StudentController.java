package com.allclearwas.domains.student.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.allclearwas.common.response.SuccessResponse;
import com.allclearwas.common.security.authentication.SecurityUserDetails;
import com.allclearwas.domains.student.dto.response.StudentInfoResponse;
import com.allclearwas.domains.student.service.StudentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/students")
public class StudentController {

	private final StudentService studentService;

	@Operation(
		summary = "학생 기본정보 조회",
		description = "로그인한 학생의 이름, 학번, 학기를 조회합니다.",
		security = {@SecurityRequirement(name = "JWT")}
	)
	@ApiResponses(value = {
		@ApiResponse(responseCode = "2000", description = "학생 정보 조회 성공"),
		@ApiResponse(responseCode = "404", description = "해당 학생이 존재하지 않음"),
		@ApiResponse(responseCode = "403", description = "JWT 인증 실패")
	})

	@GetMapping("/me")
	public SuccessResponse<StudentInfoResponse> getStudentInfo(
		@AuthenticationPrincipal SecurityUserDetails userDetails) {
		Long studentId = userDetails.getStudentId();
		StudentInfoResponse response = studentService.getStudentInfo(studentId);
		return SuccessResponse.of(response);
	}
}
