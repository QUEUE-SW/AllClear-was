package com.allclearwas.common.exception;

public interface BaseErrorCode {
	ErrorCausedBy errorCausedBy();
	String getErrorMessage();
}
