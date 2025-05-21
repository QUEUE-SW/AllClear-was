package com.allclearwas.common.annotation.swagger;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
@ApiResponse(responseCode = "401 - 만료된 토큰", description = "만료된 토큰일 경우",
	content = @Content(mediaType = "application/json", examples = {
		@ExampleObject(name = "만료된 토큰", value = """
			{
			    "code": "4011",
			    "message": "만료된 토큰입니다.",
			    "errors": []
			}
			    """)
	}))
@ApiResponse(responseCode = "401 - 유효하지 않은 토큰", description = "유효하지 않은 토큰 형식일 경우",
	content = @Content(mediaType = "application/json", examples = {
		@ExampleObject(name = "유효하지 않은 형식", value = """
			{
			  "code": "4013",
			  "message": "유효하지 않은 형식의 토큰입니다.",
			  "errors": []
			}
			    """)
	}))
@ApiResponse(responseCode = "401 - 사용할 수 없는 토큰", description = "사용할 수 없는 토큰일 경우",
	content = @Content(mediaType = "application/json", examples = {
		@ExampleObject(name = "사용할 수 없는 토큰", value = """
			{
			    "code": "4014",
			    "message": "사용할 수 없는 토큰입니다.",
			    "errors": []
			}
			    """)
	}))
@ApiResponse(responseCode = "401 - 조작된 토큰", description = "조작된 토큰일 경우",
	content = @Content(mediaType = "application/json", examples = {
		@ExampleObject(name = "조작된 토큰", value = """
			{
			    "code": "4015",
			    "message": "조작된 토큰입니다.",
			    "errors": []
			}
			    """)
	}))
@ApiResponse(responseCode = "401 - 인증 과정 오류", description = "인증이 필요하나 인증되지 않았거나 유효한 인증 정보가 없는 경우",
	content = @Content(mediaType = "application/json", examples = {
		@ExampleObject(name = "인증 실패", value = """
			{
			  "code": "4012",
			  "message": "JWT 인증 과정에서 오류가 발생했습니다.",
			  "errors": []
			}
			    """)
	}))
public @interface AuthenticationApi {
}
