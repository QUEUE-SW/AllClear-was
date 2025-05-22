package com.allclearwas.domains.course.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.allclearwas.common.response.SuccessResponse;
import com.allclearwas.domains.course.api.CourseListApi;
import com.allclearwas.domains.course.dto.response.CourseListRes;
import com.allclearwas.domains.course.service.CourseService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/courses")
public class CourseListController implements CourseListApi {

	private final CourseService courseService;

	@PreAuthorize("isAuthenticated()")
	@GetMapping
	public ResponseEntity<?> getCourseList() {
		List<CourseListRes> response = courseService.getCourseList();
		return ResponseEntity.ok(SuccessResponse.of(response));
	}
}
