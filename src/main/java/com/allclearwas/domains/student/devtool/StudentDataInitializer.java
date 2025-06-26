package com.allclearwas.domains.student.devtool;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.allclearwas.domains.student.domain.Student;
import com.allclearwas.domains.student.domain.StudentPolicy;
import com.allclearwas.domains.student.repository.StudentPolicyRepository;
import com.allclearwas.domains.student.repository.StudentRepository;
import com.allclearwas.domains.student.type.College;
import com.allclearwas.domains.student.type.Department;
import com.allclearwas.domains.student.type.Major;
import com.allclearwas.domains.student.type.Semester;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class StudentDataInitializer implements CommandLineRunner {

	private final StudentRepository studentRepository;
	private final StudentPolicyRepository studentPolicyRepository;
	private final PasswordEncoder passwordEncoder;
	private static final String TESTNAME = "test";
	private static final String PASSWORD = "test1234";

	@Override
	@Transactional
	public void run(String... args) {
		System.out.println("🔥 StudentDataInitializer 실행됨");
		int total = 10_000;
		int perMajor = 2_500;
		Major[] majors = {Major.CSE, Major.ICE, Major.SC, Major.ALL};

		List<Student> students = new ArrayList<>(total);
		List<StudentPolicy> policies = new ArrayList<>(total);

		for (int i = 1; i <= total; i++) {
			Major major = majors[(i - 1) / perMajor];
			String identifier = String.format("%08d", i);
			String name = TESTNAME + identifier;

			Student student = Student.builder()
				.identifier(identifier)
				.password(passwordEncoder.encode(PASSWORD))
				.name(name)
				.college(College.DIGITAL_CONVERGENCE)
				.department(Department.COMPUTER_SCIENCE_AND_ENGINEERING)
				.major(major)
				.grade(4)
				.build();

			students.add(student);
			System.out.println("✅ student 추가 완료" + i);
		}

		studentRepository.saveAll(students);
		System.out.println("✅ student 저장 완료");

		for (Student student : students) {
			StudentPolicy policy = StudentPolicy.builder()
				.student(student)
				.currentCredits(0)
				.minCredits(15)
				.maxCredits(18)
				.semester(Semester.FIRST)
				.build();

			policies.add(policy);
			System.out.println("✅ student_policy 추가 완료" + student.getId());
		}

		studentPolicyRepository.saveAll(policies);
		System.out.println("student_policy 저장 완료");
	}
}

