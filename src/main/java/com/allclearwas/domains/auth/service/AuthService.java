package com.allclearwas.domains.auth.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.allclearwas.common.exception.auth.AuthErrorCode;
import com.allclearwas.common.exception.auth.AuthException;
import com.allclearwas.common.exception.student.StudentErrorCode;
import com.allclearwas.common.exception.student.StudentException;
import com.allclearwas.domains.auth.dto.request.SignInReq;
import com.allclearwas.domains.auth.dto.request.SignupReq;
import com.allclearwas.domains.auth.dto.response.SignInRes;
import com.allclearwas.domains.auth.dto.response.SignupRes;
import com.allclearwas.domains.auth.implement.TokenGenerator;
import com.allclearwas.domains.student.domain.Student;
import com.allclearwas.domains.student.domain.StudentPolicy;
import com.allclearwas.domains.student.implement.StudentAppender;
import com.allclearwas.domains.student.implement.StudentPolicyAppender;
import com.allclearwas.domains.student.implement.StudentReader;
import com.allclearwas.domains.student.implement.StudentValidator;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class AuthService {
	private final PasswordEncoder passwordEncoder;
	private final StudentAppender studentAppender;
	private final StudentReader studentReader;
	private final StudentValidator studentValidator;
	private final StudentPolicyAppender studentPolicyAppender;
	private final TokenGenerator tokenGenerator;

	public SignupRes signUp(SignupReq signupReq) {
		studentValidator.checkDuplicateStudent(signupReq.identifier());

		Student student = signupReq.toEntity(passwordEncoder);
		studentAppender.append(student);

		StudentPolicy studentPolicy = StudentPolicy.of(student);
		studentPolicyAppender.append(studentPolicy);

		return SignupRes.from(student.getId());
	}

	public SignInRes signIn(SignInReq signInReq) {
		log.debug("SignInReq: {}", signInReq);
		Student student = studentReader.readByIdentifier(signInReq.identifier())
			.orElseThrow(() -> new StudentException(StudentErrorCode.STUDENT_NOT_FOUND));

		if (!passwordEncoder.matches(signInReq.password(), student.getPassword())) {
			throw new AuthException(AuthErrorCode.PASSWORD_MISMATCH);
		}

		String token = tokenGenerator.generateToken(student.getId(), student.getIdentifier());
		return SignInRes.of(student.getId(), token);
	}

}
