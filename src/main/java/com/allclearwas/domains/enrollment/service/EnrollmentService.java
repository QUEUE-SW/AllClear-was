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
import com.allclearwas.domains.course.implement.CourseUpdater;
import com.allclearwas.domains.enrollment.domain.Enrollment;
import com.allclearwas.domains.enrollment.dto.response.CourseEnrollmentCountRes;
import com.allclearwas.domains.enrollment.dto.response.EnrollmentRes;
import com.allclearwas.domains.enrollment.implement.EnrollmentAppender;
import com.allclearwas.domains.enrollment.implement.EnrollmentDeleter;
import com.allclearwas.domains.enrollment.implement.EnrollmentReader;
import com.allclearwas.domains.enrollment.implement.EnrollmentValidator;
import com.allclearwas.domains.student.domain.Student;
import com.allclearwas.domains.student.domain.StudentPolicy;
import com.allclearwas.domains.student.implement.StudentPolicyReader;
import com.allclearwas.domains.student.implement.StudentPolicyUpdater;
import com.allclearwas.domains.student.implement.StudentReader;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class EnrollmentService {

	private final EnrollmentReader enrollmentReader;
	private final EnrollmentAppender enrollmentAppender;
	private final EnrollmentDeleter enrollmentDeleter;
	private final StudentReader studentReader;
	private final StudentPolicyUpdater studentPolicyUpdater;
	private final StudentPolicyReader studentPolicyReader;
	private final EnrollmentValidator enrollmentValidator;
	private final CourseReader courseReader;
	private final CourseUpdater courseUpdater;

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

		// 동일 이름 과목 신청 여부 확인
		if (enrollmentReader.existsByStudentIdAndSameCourseName(studentId, course.getName())) {
			throw new EnrollmentException(EnrollmentErrorCode.ALREADY_ENROLLED_SAME_COURSE_NAME);
		}

		// 전공 제한 검증
		enrollmentValidator.validateMajorPermission(student.getMajor(), course.getCourseInfo().getMajor());

		// 학생 정책 조회 및 최대 학점 초과 여부 확인
		StudentPolicy policy = studentPolicyReader.read(studentId)
			.orElseThrow(() -> new StudentException(StudentErrorCode.STUDENT_POLICY_NOT_FOUND));
		enrollmentValidator.validateCreditLimit(policy.getCurrentCredits(), course.getCredit(),
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
		log.info("[수강신청 Before] {} 강의 신청자 수: {}", course.getName(), course.getParticipant());
		courseUpdater.increaseCourseParticipant(course);
		log.info("[수강신청 After] {} 강의 신청자 수: {}", course.getName(), course.getParticipant());

		// Enrollment 저장
		Enrollment enrollment = enrollmentAppender.save(student, course);

		// 학생 학점 증가
		studentPolicyUpdater.increaseStudentCredits(policy, course.getCredit());

		// 응답 반환
		return EnrollmentRes.of(enrollment);
	}

	@Transactional
	public void deleteEnrollment(Long enrollmentId, Long studentId) {

		// 수강신청 정보 조회
		Enrollment enrollment = enrollmentReader.read(enrollmentId)
				.orElseThrow(() -> new EnrollmentException(EnrollmentErrorCode.ENROLLMENT_NOT_FOUND));


		// 수강신청 정보 소유자 검증
		if (!enrollmentReader.isOwnedByStudent(enrollment.getId(), studentId)) {
			throw new EnrollmentException(EnrollmentErrorCode.UNAUTHORIZED_STUDENT);
		}

		// 강의 ID 조회
		Long courseId = enrollmentReader.readCourseId(enrollment.getId());

		// 과목 정보 조회 및 락
		Course course = courseReader.readWithPessimisticLock(courseId)
			.orElseThrow(() -> new EnrollmentException(EnrollmentErrorCode.ENROLLMENT_NOT_FOUND));

		// 학생 정책 조회
		StudentPolicy policy = studentPolicyReader.read(studentId)
			.orElseThrow(() -> new StudentException(StudentErrorCode.STUDENT_POLICY_NOT_FOUND));

		// 수강 인원 감소
		log.info("[수강취소 Before] {} 강의 신청자 수: {}", course.getName(), course.getParticipant());
		courseUpdater.decreaseCourseParticipant(course);
		log.info("[수강취소 After] {} 강의 신청자 수 {}", course.getName(), course.getParticipant());

		// 학생 학점 감소
		studentPolicyUpdater.decreaseStudentCredits(policy, course.getCredit());

		// 수강 신청 정보 삭제
		enrollmentDeleter.delete(enrollment);
	}
}
