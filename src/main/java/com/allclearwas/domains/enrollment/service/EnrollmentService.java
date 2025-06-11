package com.allclearwas.domains.enrollment.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.allclearwas.common.exception.enrollment.EnrollmentErrorCode;
import com.allclearwas.common.exception.enrollment.EnrollmentException;
import com.allclearwas.common.exception.student.StudentErrorCode;
import com.allclearwas.common.exception.student.StudentException;
import com.allclearwas.domains.course.domain.Course;
import com.allclearwas.domains.course.implement.CourseReader;
import com.allclearwas.domains.enrollment.domain.Enrollment;
import com.allclearwas.domains.enrollment.dto.response.CourseEnrollmentCountRes;
import com.allclearwas.domains.enrollment.dto.response.EnrollmentRes;
import com.allclearwas.domains.enrollment.implement.EnrollmentAppender;
import com.allclearwas.domains.enrollment.implement.EnrollmentReader;
import com.allclearwas.domains.student.domain.Student;
import com.allclearwas.domains.student.domain.StudentPolicy;
import com.allclearwas.domains.student.implement.StudentPolicyReader;
import com.allclearwas.domains.student.implement.StudentPolicyUpdater;
import com.allclearwas.domains.student.implement.StudentPolicyValidator;
import com.allclearwas.domains.student.implement.StudentReader;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class EnrollmentService {

	private final EnrollmentReader enrollmentReader;
	private final EnrollmentAppender enrollmentAppender;
	private final StudentReader studentReader;
	private final StudentPolicyUpdater studentPolicyUpdater;
	private final StudentPolicyReader studentPolicyReader;
	private final StudentPolicyValidator studentPolicyValidator;
	private final CourseReader courseReader;

	public List<CourseEnrollmentCountRes> getEnrolledCount(List<Long> courseIds) {
		List<CourseEnrollmentCountRes> countList = courseReader.getEnrollmentCount(courseIds);
		return countList;
	}

	@Transactional
	public EnrollmentRes enrollCourse(Long courseId, Long studentId) {

		// 해당 과목 신청 여부 확인
		if (enrollmentReader.isAlreadyEnrolled(studentId, courseId)) {
			throw new EnrollmentException(EnrollmentErrorCode.ALREADY_ENROLLED);
		}

		// 학생 정보 조회
		Student student = studentReader.read(studentId)
			.orElseThrow(() -> new StudentException(StudentErrorCode.STUDENT_NOT_FOUND));

		// 과목 정보 조회 및 락
		Course course = courseReader.readWithPessimisticLock(courseId)
			.orElseThrow(() -> new EnrollmentException(EnrollmentErrorCode.ENROLLMENT_NOT_FOUND));

		// 학생 정책 조회 및 최대 학점 초과 여부 확인
		StudentPolicy policy = studentPolicyReader.read(studentId)
			.orElseThrow(() -> new StudentException(StudentErrorCode.STUDENT_POLICY_NOT_FOUND));
		studentPolicyValidator.validateCreditLimit(policy.getCurrentCredits(), course.getCredit(),
			policy.getMaxCredits());

		// 시간 중복 여부 확인
		if (enrollmentReader.existsOverlappingTime(studentId, courseId)) {
			throw new EnrollmentException(EnrollmentErrorCode.COURSE_TIME_OVERLAP);
		}

		// DB 자리 확인
		if (course.getParticipant() >= course.getCapacity()) {
			throw new EnrollmentException(EnrollmentErrorCode.NO_AVAILABLE_SEATS);
		}

		// 수강 인원 증가
		course.incrementParticipant();

		// Enrollment 저장
		Enrollment enrollment = enrollmentAppender.save(student, course);

		// 학생 학점 갱신
		studentPolicyUpdater.updateStudentCredits(policy, course.getCredit());

		// 응답 반환
		return EnrollmentRes.of(enrollment);
	}
}
