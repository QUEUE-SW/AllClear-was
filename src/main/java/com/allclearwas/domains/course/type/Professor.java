package com.allclearwas.domains.course.type;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Professor {

	JONGWOOK_KWAK("곽종욱"),
	YOUNGDEOK_PARK("갓영덕"),
	CHANGHYEON_PARK("박창현"),
	SEOKSEO_YEONG("서영석"),
	JONGHEE_YOUN("윤종희"),
	HAENGRAE_CHO("조행래"),
	SEJONG_LEE("이세종");

	private final String name;
}
