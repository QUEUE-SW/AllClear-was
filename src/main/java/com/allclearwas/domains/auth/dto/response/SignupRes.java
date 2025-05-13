package com.allclearwas.domains.auth.dto.response;

public record SignupRes(Long id) {
	public static SignupRes from(Long id) {
		return new SignupRes(id);
	}
}
