package com.allclearwas.common.exception.jwt;

import com.allclearwas.common.exception.GlobalException;

public class TokenException extends GlobalException {

	public TokenException(TokenErrorCode tokenErrorCode) {
		super(tokenErrorCode);
	}
}
