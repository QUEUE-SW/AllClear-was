package com.allclearwas.domains.enrollment.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.allclearwas.common.response.SuccessResponse;
import com.allclearwas.domains.enrollment.api.EnrollmentCapacityApi;
import com.allclearwas.domains.enrollment.dto.request.CourseEnrollmentCountReq;
import com.allclearwas.domains.enrollment.dto.response.CourseEnrollmentCountRes;
import com.allclearwas.domains.enrollment.service.EnrollmentService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/enrollments")
public class EnrollmentCapacityController implements EnrollmentCapacityApi {

	private final EnrollmentService enrollmentService;

	@PreAuthorize("isAuthenticated()")
	@PostMapping("/capacities")
	public ResponseEntity<?> getEnrolledCount(@RequestBody CourseEnrollmentCountReq courseEnrollmentCountReq) {
		log.debug("Requested courseIds: {}", courseEnrollmentCountReq.ids());
		List<CourseEnrollmentCountRes> response = enrollmentService.getEnrolledCount(courseEnrollmentCountReq.ids());
		log.debug("CourseEnrollmentCount List: {}", response);
		return ResponseEntity.ok(SuccessResponse.of(response));
	}
}
