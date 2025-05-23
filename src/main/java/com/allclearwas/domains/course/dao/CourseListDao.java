package com.allclearwas.domains.course.dao;

import com.allclearwas.domains.course.type.Location;
import com.allclearwas.domains.course.type.Professor;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CourseListDao {
	private Long courseId;
	private String courseCode;
	private String name;
	private Professor professor;
	private Location location;
	private int capacity;
	private int credit;
	private String time1;
	private String time2;
}
