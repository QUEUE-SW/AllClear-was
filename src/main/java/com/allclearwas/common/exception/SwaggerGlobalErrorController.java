package com.allclearwas.common.exception;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

import com.allclearwas.common.annotation.swagger.AuthenticationApi;
import com.allclearwas.common.annotation.swagger.CommonApi;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
public class SwaggerGlobalErrorController {

	@Tag(name = "GLOBAL ERROR API", description = "전역으로 발생하는 예외")
	@CommonApi
	@AuthenticationApi
	@DeleteMapping("/global-error")
	private void error() {
	}
}
