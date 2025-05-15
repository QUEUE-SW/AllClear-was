package com.allclearwas.common.security.authentication;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.allclearwas.domains.student.domain.Student;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SecurityUserDetails implements UserDetails {

	private Long studentId;
	private String identifier;
	private Collection<GrantedAuthority> authorities;

	@Builder
	public SecurityUserDetails(Long studentId, String identifier, Collection<GrantedAuthority> authorities) {
		this.studentId = studentId;
		this.identifier = identifier;
		this.authorities = authorities;
	}

	public static SecurityUserDetails from(Student student) {
		return SecurityUserDetails.builder()
			.studentId(student.getId())
			.identifier(String.valueOf(student.getIdentifier()))
			.authorities(List.of(new SimpleGrantedAuthority("STUDENT")))
			.build();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return null;
	}

	@Override
	public String getUsername() {
		return null;
	}
}
