package com.allclearwas.domains.enrollment.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.allclearwas.domains.enrollment.dto.EnrolledCountRes;
import com.allclearwas.domains.enrollment.repository.EnrollmentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EnrollmentService {

	private final EnrollmentRepository enrollmentRepository;

	public List<EnrolledCountRes> getEnrolledCount(List<Long> courseIds) {
		return enrollmentRepository.countByCourseId(courseIds);
	}
}
