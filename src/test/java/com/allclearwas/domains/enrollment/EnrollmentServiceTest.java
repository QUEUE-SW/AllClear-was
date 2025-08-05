package com.allclearwas.domains.enrollment;

/*
import static org.junit.jupiter.api.Assertions.*;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.allclearwas.TestDatabaseConfig;
import com.allclearwas.domains.course.domain.Course;
import com.allclearwas.domains.course.domain.CourseInfo;
import com.allclearwas.domains.course.domain.CourseTime;
import com.allclearwas.domains.course.repository.CourseInfoRepository;
import com.allclearwas.domains.course.repository.CourseRepository;
import com.allclearwas.domains.course.repository.CourseTimeRepository;
import com.allclearwas.domains.course.type.Category;
import com.allclearwas.domains.course.type.Location;
import com.allclearwas.domains.course.type.Professor;
import com.allclearwas.domains.enrollment.service.EnrollmentService;
import com.allclearwas.domains.student.domain.Student;
import com.allclearwas.domains.student.domain.StudentPolicy;
import com.allclearwas.domains.student.repository.StudentPolicyRepository;
import com.allclearwas.domains.student.repository.StudentRepository;
import com.allclearwas.domains.student.type.College;
import com.allclearwas.domains.student.type.Department;
import com.allclearwas.domains.student.type.Major;
import com.allclearwas.domains.student.type.Semester;

@SpringBootTest
public class EnrollmentServiceTest extends TestDatabaseConfig {

	@Autowired
	private EnrollmentService enrollmentService;
	@Autowired
	private CourseRepository courseRepository;
	@Autowired
	private CourseTimeRepository courseTimeRepository;
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private StudentPolicyRepository studentPolicyRepository;
	@Autowired
	private CourseInfoRepository courseInfoRepository;

	private Long savedCourseId;

	@BeforeEach
	void setup() {
		// 강의 정보 생성
		CourseInfo courseInfo = CourseInfo.builder()
			.semester(Semester.FIRST)
			.category(Category.MAJOR)
			.college(College.ENGINEERING)
			.department(Department.COMPUTER_SCIENCE_AND_ENGINEERING)
			.major(Major.ALL)
			.grade(1)
			.build();
		courseInfo = courseInfoRepository.save(courseInfo);

		// 강의 생성 (정원 40명)
		Course course = Course.builder()
			.name("테스트 강의")
			.professor(Professor.JONGWOOK_KWAK)
			.location(Location.B02_152)
			.credit(3)
			.capacity(40)
			.category(Category.MAJOR)
			.participant(0)
			.courseInfo(courseInfo)
			.build();
		Course savedCourse = courseRepository.save(course);
		savedCourseId = savedCourse.getId();

		// 강의 시간 생성
		CourseTime time = CourseTime.builder()
			.dayOfWeek(DayOfWeek.MONDAY)
			.startTime(LocalTime.of(9, 0))
			.endTime(LocalTime.of(10, 0))
			.course(savedCourse)
			.build();
		courseTimeRepository.save(time);

		// 학생 100명 + 정책 등록
		for (int i = 1; i <= 100; i++) {
			Student student = studentRepository.save(Student.builder()
				.identifier("student" + i)
				.password("pwd1234")
				.name("학생" + i)
				.college(College.ENGINEERING)
				.department(Department.COMPUTER_SCIENCE_AND_ENGINEERING)
				.major(Major.CSE)
				.grade(1)
				.build());
			studentPolicyRepository.save(StudentPolicy.of(student));
		}
	}

	@Test
	void 수강신청_동시성_정원40명_40명만성공() throws InterruptedException {
		List<Long> studentIds = studentRepository.findAll().stream().map(Student::getId).toList();

		ExecutorService executor = Executors.newFixedThreadPool(studentIds.size());

		CountDownLatch readyLatch = new CountDownLatch(studentIds.size()); // 준비 완료 확인용
		CountDownLatch startLatch = new CountDownLatch(1); // 동시에 시작시키기 위한 latch
		CountDownLatch endLatch = new CountDownLatch(studentIds.size());  // 전체 작업 완료 대기

		AtomicInteger successCount = new AtomicInteger();
		AtomicInteger failCount = new AtomicInteger();

		for (Long studentId : studentIds) {
			executor.submit(() -> {
				try {
					readyLatch.countDown();
					startLatch.await();
					enrollmentService.enrollCourse(savedCourseId, studentId);
					successCount.incrementAndGet(); // 성공한 경우만 카운트
				} catch (Exception e) {
					failCount.incrementAndGet();
					System.out.println("실패한 studentId: " + studentId + "-> " + e.getMessage());
				} finally {
					endLatch.countDown();
				}
			});
		}

		readyLatch.await();
		startLatch.countDown();
		endLatch.await();
		executor.shutdown();

		Course course = courseRepository.findById(savedCourseId).orElseThrow();
		System.out.println("최종 수강 인원: " + course.getParticipant());

		assertEquals(40, successCount.get(), "정원이 40명이므로 40명만 성공해야 함");
		assertEquals(60, failCount.get(), "100명 중 60명이 실패해야함");
		assertEquals(40, course.getParticipant(), "Course의 participant 필드도 40이어야 함");
	}
}
*/
