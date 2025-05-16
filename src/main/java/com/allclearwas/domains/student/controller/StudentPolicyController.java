package com.allclearwas.domains.student.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.allclearwas.common.response.SuccessResponse;
import com.allclearwas.common.security.authentication.SecurityUserDetails;
import com.allclearwas.domains.student.dto.response.StudentCreditRes;
import com.allclearwas.domains.student.service.StudentService;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@RequestMapping("/api/v1/student_polices")
public class StudentPolicyController {

	private final StudentService studentService;

	@GetMapping("/credits")
	public ResponseEntity<?> getStudentPolicyInfo(@AuthenticationPrincipal SecurityUserDetails userDetails) {
		Long studentId = userDetails.getStudentId();
		StudentCreditRes response = studentService.getStudentPolicyInfo(studentId);
		return ResponseEntity.ok(SuccessResponse.of(response));
	}
}
