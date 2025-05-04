package com.allclearwas.domains.student.domain;

import com.allclearwas.domains.student.type.Semester;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StudentPolicy {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_policy_id")
	private Long id;

	private int maxCredits;
	private int minCredits;
	private int currentCredits;
	private int generalEducationCredits;
	private int majorCredits;

	@Enumerated(EnumType.STRING)
	private Semester semester;

}
