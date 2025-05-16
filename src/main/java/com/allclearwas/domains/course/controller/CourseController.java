package com.allclearwas.domains.course.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.allclearwas.common.response.SuccessResponse;
import com.allclearwas.domains.course.dto.response.CourseListRes;
import com.allclearwas.domains.course.service.CourseService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/courses")
public class CourseController {

	private final CourseService courseService;

	@GetMapping
	public ResponseEntity<?> getCourseList() {
		List<CourseListRes> response = courseService.getCourseList();
		return ResponseEntity.ok(SuccessResponse.of(response));
	}
}
