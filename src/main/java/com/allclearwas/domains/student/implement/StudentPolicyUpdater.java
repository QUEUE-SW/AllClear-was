package com.allclearwas.domains.student.implement;

import com.allclearwas.common.annotation.Implementation;
import com.allclearwas.domains.student.domain.StudentPolicy;

import lombok.RequiredArgsConstructor;

@Implementation
@RequiredArgsConstructor
public class StudentPolicyUpdater {

	public void increaseStudentCredits(StudentPolicy policy, int additionalCredits) {
		policy.increaseCurrentCredits(additionalCredits);
	}

	public void decreaseStudentCredits(StudentPolicy policy, int additionalCredits) {
		policy.decreaseCurrentCredits(additionalCredits);
	}
}
