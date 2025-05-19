package com.allclearwas.domains.course.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.allclearwas.common.response.SuccessResponse;
import com.allclearwas.common.security.authentication.SecurityUserDetails;
import com.allclearwas.domains.course.api.CourseListApi;
import com.allclearwas.domains.course.api.MyCourseListApi;
import com.allclearwas.domains.course.dto.response.CourseListRes;
import com.allclearwas.domains.course.dto.response.MyCourseListRes;
import com.allclearwas.domains.course.service.CourseService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/courses")
public class CourseController implements CourseListApi, MyCourseListApi {

	private final CourseService courseService;

	@GetMapping
	public ResponseEntity<?> getCourseList() {
		List<CourseListRes> response = courseService.getCourseList();
		return ResponseEntity.ok(SuccessResponse.of(response));
	}

	@GetMapping("/me")
	public ResponseEntity<?> getMyCourses(@AuthenticationPrincipal SecurityUserDetails userDetails) {
		Long studentId = userDetails.getStudentId();
		List<MyCourseListRes> response = courseService.getMyCourses(studentId);
		return ResponseEntity.ok(SuccessResponse.of(response));
	}
}
