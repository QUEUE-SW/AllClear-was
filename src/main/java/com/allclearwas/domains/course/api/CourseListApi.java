package com.allclearwas.domains.course.api;

import org.springframework.http.ResponseEntity;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "모든 강의 조회 API")
public interface CourseListApi {

	@Operation(
		summary = "모든 강의정보 조회",
		description = "개설된 모든 강의 목록을 조회한다.",
		security = {@SecurityRequirement(name = "JWT")}
	)
	@ApiResponses(value = {
		@ApiResponse(responseCode = "2000", description = "강의 목록 조회 성공",
			content = @Content(mediaType = "application/json", examples = {
				@ExampleObject(name = "성공 예시", value = """
					{
					    "code": "2000",
					       "message": "요청에 성공하였습니다.",
					       "data": [
					         {
					           "courseId": 1,
					           "courseCode": "cs101",
					           "name": "컴퓨터프로그래밍",
					           "professor": "박대영",
					           "location": "IT관 117",
					           "capacity": "20",
					           "credit": 3,
					           "time1": "월 10:00~11:30",
					           "time2": "수 12:00~13:30"
					         },
					         ...
					       ]
					}
					""")
			}))
	})
	ResponseEntity<?> getCourseList();
}
