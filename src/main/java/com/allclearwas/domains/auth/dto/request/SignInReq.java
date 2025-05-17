package com.allclearwas.domains.auth.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

public record SignInReq(

	@NotBlank(message = "학번을 입력해주세요.")
	@Schema(description = "학번", example = "22012155")
	String identifier,

	@NotBlank(message = "비밀번호를 입력해주세요.")
	@Schema(description = "비밀번호", example = "test1234!")
	String password
) {
}
