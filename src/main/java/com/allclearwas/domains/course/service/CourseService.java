package com.allclearwas.domains.course.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.allclearwas.domains.course.dto.request.CourseFilterReq;
import com.allclearwas.domains.course.dto.response.CourseListRes;
import com.allclearwas.domains.course.dto.response.MyCourseListRes;
import com.allclearwas.domains.course.implement.CourseReader;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CourseService {

	private final CourseReader courseReader;

	public List<CourseListRes> getfilterCourses(CourseFilterReq request) {
		return courseReader.findFilteredCourses(request).stream()
			.map(CourseListRes::of)
			.toList();
	}

	public List<MyCourseListRes> getMyCourses(Long studentId) {
		return courseReader.findMyCourses(studentId)
			.stream()
			.map(MyCourseListRes::of)
			.toList();
	}
}
