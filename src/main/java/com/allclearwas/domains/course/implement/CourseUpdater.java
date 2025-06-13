package com.allclearwas.domains.course.implement;

import com.allclearwas.common.annotation.Implementation;
import com.allclearwas.domains.course.domain.Course;

import lombok.RequiredArgsConstructor;

@Implementation
@RequiredArgsConstructor
public class CourseUpdater {

	public void increaseCourseParticipant(Course course) {
		course.incrementParticipant();
	}

	public void decreaseCourseParticipant(Course course) {
		course.decrementParticipant();
	}
}
