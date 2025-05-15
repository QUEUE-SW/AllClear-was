package com.allclearwas.domains.auth.dto.request;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.allclearwas.domains.student.domain.Student;
import com.allclearwas.domains.student.type.College;
import com.allclearwas.domains.student.type.Department;
import com.allclearwas.domains.student.type.Major;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record SignupReq(

	@Min(value = 10000000, message = "학번은 8자리 숫자여야 합니다.")
	@Max(value = 99999999, message = "학번은 8자리 숫자여야 합니다.")
	@Schema(description = "학번", example = "22012155")
	int identifier,

	@NotBlank(message = "비밀번호를 입력해주세요.")
	@Schema(description = "비밀번호", example = "test1234")
	String password,

	@NotBlank(message = "이름을 입력해주세요.")
	@Schema(description = "이름", example = "주민기")
	@Pattern(regexp = "^[가-힣]{2,18}$",
		message = "이름은 2글자 ~ 18글자 사이로 입력해주세요.")
	String name,

	@Min(value = 1, message = "학년은 1학년 이상이어야 합니다.")
	@Max(value = 4, message = "학년은 4학년 이하여야 합니다.")
	int grade,

	@NotNull(message = "단과 대학을 선택해주세요.")
	@Schema(description = "단과 대학", example = "DIGITAL_CONVERGENCE")
	College college,

	@NotNull(message = "학부|학과를 선택해주세요.")
	@Schema(description = "학부|학과", example = "COMPUTER_SCIENCE_AND_ENGINEERING")
	Department department,


	@Schema(description = "전공", example = "CSE", nullable = true)
	Major major
) {

	public Student toEntity(PasswordEncoder passwordEncoder) {
		return Student.builder()
			.identifier(identifier)
			.password(passwordEncoder.encode(password))
			.name(name)
			.grade(grade)
			.college(college)
			.department(department)
			.major(major)
			.build();
	}
}
