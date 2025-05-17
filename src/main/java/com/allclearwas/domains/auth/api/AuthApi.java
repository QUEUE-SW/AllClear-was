package com.allclearwas.domains.auth.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.allclearwas.domains.auth.dto.request.SignInReq;
import com.allclearwas.domains.auth.dto.request.SignupReq;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "인증 API")
public interface AuthApi {

	@Operation(summary = "학생 회원가입", description = "학생 회원가입을 진행합니다. 미인증 사용자만 가능합니다.")
	@ApiResponse(responseCode = "200", description = "회원가입 성공", content = @Content(mediaType = "application/json", examples = {
		@ExampleObject(name = "성공", value = """
			{
			    "code": "2000",
			    "message": "요청에 성공하였습니다.",
			    "data": {
			        "id": 1
			    }
			}
			""")}))
	@ApiResponse(responseCode = "409", description = "학번 중복", content = @Content(mediaType = "application/json", examples = {
		@ExampleObject(name = "실패", value = """
			{
			    "code": "4091",
			    "message": "해당 학번의 학생이 이미 존재합니다.",
			    "errors": []
			}
			""")}))
	ResponseEntity<?> signUp(@Valid @RequestBody SignupReq signupReq);



	@Operation(summary = "학생 로그인", description = "학생 로그인을 진행합니다. 미인증 사용자만 가능합니다.")
	@ApiResponse(responseCode = "200", description = "로그인 성공", content = @Content(mediaType = "application/json", examples = {
		@ExampleObject(name = "성공", value = """
			{
			    "code": "2000",
			    "message": "요청에 성공하였습니다.",
			    "data": {
			        "id": 1,
			        "accessToken": "eyJhbGciOiJIUzUxMiJ9.eyJpZGVudGlmaWVyIjoib3duZXIwNjAzIiwib3duZXJJZCI6MSwiZXhwIjoxNzI5NDg5NDUwfQ.r-8H7XGxz1-IP2cNo3jWgEuMJAxoL_HCC11kXzhDWuAqBjJYqcReXdIzA3lvQITiAewrKppZKNgcu20Tuf785A"
			    }
			}
			""")}))
	@ApiResponse(responseCode = "401", description = "비밀번호 미일치", content = @Content(mediaType = "application/json", examples = {
		@ExampleObject(name = "실패", value = """
			{
			    "code": "4010",
			    "message": "입력한 비밀번호가 현재 비밀번호와 일치하지 않습니다.",
			    "errors": []
			}
			""")}))
	ResponseEntity<?> signIn(@Valid @RequestBody SignInReq signInReq);
}
