package com.allclearwas.domains.enrollment.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.allclearwas.domains.course.implement.CourseReader;
import com.allclearwas.domains.enrollment.dto.response.CourseEnrollmentCountRes;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class EnrollmentService {

	private final CourseReader courseReader;

	public List<CourseEnrollmentCountRes> getEnrolledCount(List<Long> courseIds) {
		List<CourseEnrollmentCountRes> countList = courseReader.getEnrollmentCount(courseIds);
		return countList;
	}
}
