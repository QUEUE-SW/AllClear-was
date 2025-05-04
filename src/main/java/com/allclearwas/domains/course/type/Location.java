package com.allclearwas.domains.course.type;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Location {

	IT110("IT관 110호"),
	IT111("IT관 111호"),
	IT112("IT관 112호"),
	IT113("IT관 113호"),
	IT114("IT관 114호"),
	IT115("IT관 115호"),
	IT116("IT관 116호"),
	IT117("IT관 117호"),
	IT118("IT관 118호");

	private final String name;
}
