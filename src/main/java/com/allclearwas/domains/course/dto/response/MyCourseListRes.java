package com.allclearwas.domains.course.dto.response;

import com.allclearwas.domains.course.domain.Course;
import com.allclearwas.domains.course.type.Location;
import com.allclearwas.domains.course.type.Professor;

import io.swagger.v3.oas.annotations.media.Schema;

public record MyCourseListRes(
	@Schema(example = "1") Long enrollmentId,
	@Schema(example = "1") Long courseId,
	@Schema(example = "cs101") String courseCode,
	@Schema(example = "컴퓨터프로그래밍") String name,
	@Schema(example = "박대영") Professor professor,
	@Schema(example = "IT관 117") Location location,
	@Schema(example = "20") int capacity,
	@Schema(example = "3") int credit,
	@Schema(example = "월 10:00~11:30") String time1,
	@Schema(example = "수 12:00~13:30") String time2
) {
	public static MyCourseListRes of(Long enrollmentId, Course course, String time1, String time2) {
		return new MyCourseListRes(
			enrollmentId,
			course.getId(),
			course.getCourseCode(),
			course.getName(),
			course.getProfessor(),
			course.getLocation(),
			course.getCapacity(),
			course.getCredit(),
			time1,
			time2
		);
	}
}
