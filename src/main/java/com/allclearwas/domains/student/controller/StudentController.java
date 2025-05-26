package com.allclearwas.domains.student.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.allclearwas.common.response.SuccessResponse;
import com.allclearwas.common.security.authentication.SecurityUserDetails;
import com.allclearwas.domains.student.api.StudentProfileApi;
import com.allclearwas.domains.student.dto.response.StudentProfileRes;
import com.allclearwas.domains.student.service.StudentService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/students")
public class StudentController implements StudentProfileApi {

	private final StudentService studentService;

	@PreAuthorize("isAuthenticated()")
	@GetMapping("/me")
	public ResponseEntity<?> getStudentInfo(
		@AuthenticationPrincipal SecurityUserDetails userDetails) {
		Long studentId = userDetails.getStudentId();
		StudentProfileRes response = studentService.getStudentInfo(studentId);
		log.debug("StudentProfileRes: {}", response);
		return ResponseEntity.ok(SuccessResponse.of(response));
	}
}

