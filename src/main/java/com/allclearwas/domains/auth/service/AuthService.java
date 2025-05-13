package com.allclearwas.domains.auth.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.allclearwas.domains.auth.dto.request.SignupReq;
import com.allclearwas.domains.auth.dto.response.SignupRes;
import com.allclearwas.domains.student.domain.Student;
import com.allclearwas.domains.student.implement.StudentAppender;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthService {
	private final PasswordEncoder passwordEncoder;
	private final StudentAppender studentAppender;

	public SignupRes signup(SignupReq signupReq) {
		Student student = signupReq.toEntity(passwordEncoder);
		studentAppender.append(student);

		return SignupRes.from(student.getId());
	}
}
