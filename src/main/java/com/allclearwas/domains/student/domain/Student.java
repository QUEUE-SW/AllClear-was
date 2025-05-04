package com.allclearwas.domains.student.domain;

import com.allclearwas.domains.student.type.College;
import com.allclearwas.domains.student.type.Department;
import com.allclearwas.domains.student.type.Major;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_id")
	private Long id;

	@Column(nullable = false)
	private int identifier;

	@Column(nullable = false)
	private String password;

	private String name;

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
	public Student(int identifier, String password, String name, College college, Department department, Major major,
		int grade) {
		this.identifier = identifier;
		this.password = password;
		this.name = name;
		this.college = college;
		this.department = department;
		this.major = major;
		this.grade = grade;
	}
}
