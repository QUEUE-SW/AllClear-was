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
@ApiResponse(responseCode = "400 - 유효성 검증 실패", description = "유효성 검증 실패", content = @Content(
	mediaType = "application/json",
	examples = {
		@ExampleObject(name = "유효성 검증 실패", value = """
				{
				  "code": "4000",
				  "message": "fieldName: 필드는 필수입니다."
				}
				""")
	}))
@ApiResponse(responseCode = "400 - JSON 형식 오류", description = "JSON 형식 오류", content = @Content(
	mediaType = "application/json",
	examples = {
		@ExampleObject(name = "잘못된 JSON", value = """
				{
				  "code": "4001",
				  "message": "잘못된 요청 형식입니다."
				}
				""")
	}))
@ApiResponse(responseCode = "400 - 필수 파라미터 누락", description = "필수 파라미터 누락", content = @Content(
	mediaType = "application/json",
	examples = {
		@ExampleObject(name = "파라미터 누락", value = """
				{
				  "code": "4002",
				  "message": "필수 요청 파라미터가 없습니다: paramName"
				}
				""")
	}))
@ApiResponse(responseCode = "405 - 지원되지않은 HTTP 메서드", description = "지원되지 않는 HTTP METHOD", content = @Content(
	mediaType = "application/json",
	examples = {
		@ExampleObject(name = "지원되지 않는 메서드", value = """
				{
				  "code": "4050",
				  "message": "요청하신 HTTP 메서드는 지원되지 않습니다."
				}
				""")
	}))
@ApiResponse(responseCode = "429", description = "요청 제한 초과", content = @Content(
	mediaType = "application/json",
	examples = {
		@ExampleObject(name = "과도한 요청", value = """
				{
				  "code": "4290",
				  "message": "너무 많은 요청이 감지되었습니다. 잠시 후 다시 시도해주세요."
				}
				""")
	}))
public @interface CommonApi {
}
