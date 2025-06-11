package com.allclearwas.domains.course.domain;

import com.allclearwas.domains.course.type.Category;
import com.allclearwas.domains.course.type.Location;
import com.allclearwas.domains.course.type.Professor;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "course_id")
	private Long id;

	private String name;
	private String courseCode;

	@Enumerated(EnumType.STRING)
	private Professor professor;

	@Enumerated(EnumType.STRING)
	private Location location;

	private int credit;
	private int capacity;
	private int participant;

	@Enumerated(EnumType.STRING)
	private Category category;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "courseInfo_id")
	private CourseInfo courseInfo;

	@Builder
	public Course(String name, Professor professor, Location location, int credit, int capacity, int participant,
		Category category, CourseInfo courseInfo) {
		this.name = name;
		this.professor = professor;
		this.location = location;
		this.credit = credit;
		this.capacity = capacity;
		this.participant = participant;
		this.category = category;
		this.courseInfo = courseInfo;
	}

	public void incrementParticipant() {
		this.participant++;
	}
}
