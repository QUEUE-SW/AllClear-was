package com.allclearwas.domains.student.devtool;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;

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

// @Component
@RequiredArgsConstructor
public class StudentDataInitializer implements CommandLineRunner {

	private final StudentRepository studentRepository;
	private final StudentPolicyRepository studentPolicyRepository;
	private static final String TESTNAME = "test";

	@Override
	@Transactional
	public void run(String... args) {
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
				.password("test1234")
				.name(name)
				.college(College.DIGITAL_CONVERGENCE)
				.department(Department.COMPUTER_SCIENCE_AND_ENGINEERING)
				.major(major)
				.build();

			students.add(student);
		}

		studentRepository.saveAll(students);

		for (Student student : students) {
			StudentPolicy policy = StudentPolicy.builder()
				.student(student)
				.currentCredits(0)
				.minCredits(15)
				.maxCredits(18)
				.semester(Semester.FIRST)
				.build();

			policies.add(policy);
		}

		studentPolicyRepository.saveAll(policies);
	}
}

