package com.allclearwas.domains.enrollment;

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

import com.allclearwas.domains.course.domain.Course;
import com.allclearwas.domains.course.domain.CourseTime;
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

@SpringBootTest
public class EnrollmentServiceTest {

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

	private Long savedCourseId;

	@BeforeEach
	void setup() {
		// 강의 생성 (정원 1명)
		Course course = Course.builder()
			.name("테스트 강의")
			.professor(Professor.JONGWOOK_KWAK)
			.location(Location.B02_152)
			.credit(3)
			.capacity(40)
			.category(Category.MAJOR)
			.participant(0)
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

		// 학생 6명 + 정책 등록
		for (int i = 1; i <= 100; i++) {
			Student student = studentRepository.save(Student.builder()
				.identifier("student" + i)
				.password("pwd1234")
				.name("학생" + i)
				.college(College.ENGINEERING)
				.department(Department.COMPUTER_SCIENCE_AND_ENGINEERING)
				.major(Major.CSE)
				.grade(1)
				.build()
			);
			studentPolicyRepository.save(StudentPolicy.of(student));
		}
	}

	@Test
	void 수강신청_동시성_정원1명_1명만성공() throws InterruptedException {
		List<Long> studentIds = studentRepository.findAll().stream()
			.map(Student::getId)
			.toList();

		ExecutorService executor = Executors.newFixedThreadPool(studentIds.size());
		CountDownLatch latch = new CountDownLatch(studentIds.size());
		AtomicInteger successCount = new AtomicInteger();

		for (Long studentId : studentIds) {
			executor.submit(() -> {
				try {
					enrollmentService.enrollCourse(savedCourseId, studentId);
					successCount.incrementAndGet(); // 성공한 경우만 카운트
				} catch (Exception e) {
					// e.printStackTrace();
				} finally {
					latch.countDown();
				}
			});
		}

		latch.await();
		executor.shutdown();

		assertEquals(40, successCount.get(), "정원이 40명이므로 40명만 성공해야 함");
	}
}
