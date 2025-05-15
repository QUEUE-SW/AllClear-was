package com.allclearwas.common.security.authentication;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.allclearwas.domains.student.implement.StudentReader;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class CustomUserDetailService implements UserDetailsService {

	private final StudentReader studentReader;

	@Override
	public UserDetails loadUserByUsername(String studentId) throws UsernameNotFoundException {
		log.debug("[loadUserByUsername] studentId : {}", studentId);
		return studentReader.read(Long.parseLong(studentId))
			.map(SecurityUserDetails::from)
			.orElseThrow(() -> new UsernameNotFoundException("토큰에 해당하는 사용자를 찾을 수 없습니다."));
	}
}
