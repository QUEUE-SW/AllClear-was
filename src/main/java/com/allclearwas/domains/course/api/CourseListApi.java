package com.allclearwas.domains.course.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.allclearwas.domains.course.dto.request.CourseFilterRequest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "강의 필터 조회 API")
public interface CourseListApi {

	@Operation(
		summary = "모든 강의 필터링 조회",
		description = "강의 목록을 이수 구분, 학년, 학과, 강의 코드로 필터링한다."
	)
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "강의 목록 조회 성공",
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
					         } 
					       ]
					}""")}))
	})
	ResponseEntity<?> getfilterCourses(@ModelAttribute CourseFilterRequest request);
}
