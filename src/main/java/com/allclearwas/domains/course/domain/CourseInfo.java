package com.allclearwas.domains.course.domain;

import com.allclearwas.domains.course.type.Category;
import com.allclearwas.domains.student.type.College;
import com.allclearwas.domains.student.type.Department;
import com.allclearwas.domains.student.type.Major;
import com.allclearwas.domains.student.type.Semester;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CourseInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "course_info_id")
	private Long id;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Semester semester;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Category category;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private College college;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Department department;

	@Enumerated(EnumType.STRING)
	private Major major;

	@Column(nullable = false)
	private int grade;

	@Builder
	public CourseInfo(Semester semester, Category category, College college, Department department, Major major,
		int grade) {
		this.semester = semester;
		this.category = category;
		this.college = college;
		this.department = department;
		this.major = major;
		this.grade = grade;
	}
}
