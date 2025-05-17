package com.allclearwas.domains.enrollment.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.allclearwas.common.response.SuccessResponse;
import com.allclearwas.domains.enrollment.dto.EnrolledCountRes;
import com.allclearwas.domains.enrollment.service.EnrollmentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/enrollments")
public class EnrollmentController {

	private final EnrollmentService enrollmentService;

	@GetMapping("/capacities")
	public ResponseEntity<?> getEnrolledCount(@RequestParam List<Long> ids) {
		List<EnrolledCountRes> response = enrollmentService.getEnrolledCount(ids);
		return ResponseEntity.ok(SuccessResponse.of(response));
	}
}
