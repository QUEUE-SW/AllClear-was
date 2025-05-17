package com.allclearwas.domains.course.support;

import java.util.List;

import com.allclearwas.domains.course.domain.CourseTime;

public class CourseTimeFormatter {

	private static final String SPACE = " ";
	private static final String TILDE = "~";

	public static String formatTime(List<CourseTime> times, int index) {
		if (times.size() > index) {
			CourseTime time = times.get(index);
			return time.getDayOfWeek() + SPACE + time.getStartTime() + TILDE + time.getEndTime();
		}
		return "";
	}
}
