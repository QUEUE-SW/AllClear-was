package com.allclearwas.domains.enrollment.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.allclearwas.common.response.SuccessResponse;
import com.allclearwas.common.security.authentication.SecurityUserDetails;
import com.allclearwas.domains.enrollment.api.EnrollmentApi;
import com.allclearwas.domains.enrollment.dto.request.EnrollmentReq;
import com.allclearwas.domains.enrollment.dto.response.EnrollmentRes;
import com.allclearwas.domains.enrollment.service.EnrollmentService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/enrollments")
public class EnrollmentController implements EnrollmentApi {

	private final EnrollmentService enrollmentService;

	@PreAuthorize("isAuthenticated()")
	@PostMapping
	public ResponseEntity<?> enrollCourse(@RequestBody EnrollmentReq enrollmentReq,
		@AuthenticationPrincipal SecurityUserDetails userDetails) {
		log.debug("Requested courseId: {}", enrollmentReq.courseId());
		Long studentId = userDetails.getStudentId();
		EnrollmentRes response = enrollmentService.enrollCourse(enrollmentReq.courseId(), studentId);
		log.debug("Enrollment result: {}", response);
		return ResponseEntity.ok(SuccessResponse.of(response));
	}
}
