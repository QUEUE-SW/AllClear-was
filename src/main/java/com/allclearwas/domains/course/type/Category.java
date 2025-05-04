package com.allclearwas.domains.course.type;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Category {

	GENERAL("교양"),
	MAJOR("전공");

	private final String name;
}
