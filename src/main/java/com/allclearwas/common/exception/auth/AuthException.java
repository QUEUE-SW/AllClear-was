package com.allclearwas.common.exception.auth;

import com.allclearwas.common.exception.GlobalException;

public class AuthException extends GlobalException {

	public AuthException(AuthErrorCode authErrorCode) {
		super(authErrorCode);
	}
}
