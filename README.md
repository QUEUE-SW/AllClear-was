## AllClear Was

---

## 🧭 프로젝트 소개
> AllClear-Was은 **QUEUE-SW 프로젝트의 백엔드 서버**로,  
대규모 트래픽 환경에서 안정적인 수강신청을 지원합니다.  
스프링 기반의 구조와 병렬 분산 처리 기술을 활용하여 높은 동시성과 안정성을 제공하며, 프론트엔드와 연동되어 수강신청 대기열 관리, 인증/인가, 데이터 처리 등을 담당합니다.

---

## 🛠️ 기술 스택

|영역            |사용 기술              |
|----------------|-----------------------|
|**언어**        |Java 17                |
|**프레임워크**  |Spring Boot            |
|**빌드 도구**   |Gradle                 |
|**데이터베이스**|MySQL (RDS)            |
|**캐시 서버**   |Redis                  |
|**인프라**      |AWS EC2, Docker        |
|**배포**        |GitHub Actions         |
|**성능 테스트** |JMeter                 |
|**통신 방식**   |REST API, Polling, SSE |
|**협업 도구**   |Jira, Confluence, Slack|

---

## 💡 주요 기능
- 수강신청 대기열 관리 및 처리
- 사용자 인증/인가
- 대규모 트래픽 대응을 위한 비동기 처리 및 캐싱
- REST API 제공

---

## ⚙ 시스템 아키텍처
- 백엔드 아키텍처(6단계)
  - 기본 MVC
  <img width="719" height="264" alt="image_720" src="https://github.com/user-attachments/assets/ace93d2e-04ed-410c-869c-6e82c2b9abd2" />
  
  - Polling + 대기열 도입
  <img width="720" height="502" alt="image_720" src="https://github.com/user-attachments/assets/a5c0e04a-1f4a-430f-a6e2-5528bbaf8990" />

  - SSE로 변경
  <img width="720" height="517" alt="image_720" src="https://github.com/user-attachments/assets/b392c8c4-ef20-4184-b6ef-926e8032829f" />

  - Redis 도입
  <img width="720" height="466" alt="image_720" src="https://github.com/user-attachments/assets/6c855b75-6510-46e5-aa75-71cb0c6a66a9" />

  - 실시간 여석 조회
  <img width="480" height="320" alt="image_480" src="https://github.com/user-attachments/assets/661cfc8d-a24f-46a4-8a97-e2d7885c2597" />

  - 최종 Polling 다시 도입
  <img width="720" height="469" alt="image_720" src="https://github.com/user-attachments/assets/be758b08-539b-46c0-ad83-1dc7b865721c" />

- 다이어그램
<img width="947" height="437" alt="3a3421a0-b5f4-4a0d-8f78-799197810ae3" src="https://github.com/user-attachments/assets/c9b43279-51ed-4871-ac01-94c55b5c156f" />

---

## 📁 폴더 구조
```
📦AllClear-was
 ┣ 📂.git
 ┣ 📂.github
 ┣ 📂gradle
 ┣ 📂src
 ┃ ┣ 📂main
 ┃ ┃ ┣ 📂java
 ┃ ┃ ┃ ┗ 📂com
 ┃ ┃ ┃ ┃ ┗ 📂allclearwas
 ┃ ┃ ┃ ┃ ┃ ┣ 📂common
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂annotation
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂swagger
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AuthenticationApi.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜CommonApi.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜Implementation.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂exception
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂auth
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AuthErrorCode.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜AuthException.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂enrollment
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜EnrollmentErrorCode.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜EnrollmentException.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂jwt
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜TokenErrorCode.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜TokenException.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂student
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜StudentErrorCode.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜StudentException.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜BaseErrorCode.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ErrorCausedBy.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜GlobalException.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ReasonCode.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜StatusCode.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜SwaggerGlobalErrorController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂handler
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜ApiExceptionHandler.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂jwt
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜AccessTokenProvider.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂response
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ErrorResponse.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜SuccessResponse.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂security
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂authentication
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CustomUserDetailService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜SecurityUserDetails.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂filter
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜JwtAuthenticationFilter.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜JwtExceptionFilter.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂handler
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜JwtAccessDeniedHandler.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜JwtAuthenticationEntryPoint.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂config
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂security
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜FilterConfig.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜FilterRegisterConfig.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜SecurityConfig.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜WebSecurityConfig.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AsyncConfig.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CommonInitializer.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CorsConfig.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CustomTomcatConfig.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜QuerydslConfig.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜RedisConfig.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜SessionConfig.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜SwaggerConfig.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂domains
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂auth
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂api
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜AuthApi.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂controller
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜AuthController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂dto
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂request
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜SignInReq.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜SignupReq.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂response
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜SignInRes.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜SignupRes.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂implement
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜TokenGenerator.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂service
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜AuthService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂course
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂api
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CourseListApi.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜MyCourseListApi.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂controller
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CourseListController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜MyCourseListController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂dao
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CourseListDao.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜MyCourseListDao.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂domain
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Course.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CourseInfo.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜CourseTime.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂dto
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂request
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜CourseFilterReq.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂response
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CourseListRes.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜MyCourseListRes.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂implement
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CourseReader.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜CourseUpdater.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂repository
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂impl
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜QueryDslCourseRepositoryImpl.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CourseInfoRepository.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CourseRepository.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CourseTimeRepository.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜QueryDslCourseRepository.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂service
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜CourseService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂type
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Category.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Location.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜Professor.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂enrollment
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂api
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜EnrollmentApi.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜EnrollmentCapacityApi.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂controller
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜EnrollmentController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂domain
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜Enrollment.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂dto
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂request
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CourseEnrollmentCountReq.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜EnrollmentReq.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂response
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CourseEnrollmentCountRes.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜EnrollmentRes.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂implement
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜EnrollmentAppender.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜EnrollmentDeleter.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜EnrollmentReader.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜EnrollmentValidator.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂repository
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂impl
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜QueryDslEnrollmentRepositoryImpl.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜EnrollmentRepository.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜QueryDslEnrollmentRepository.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂service
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜EnrollmentService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂seat
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂controller
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜SseSeatController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂implement
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Heartbeat.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜SeatManager.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜SseAsyncSender.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜SseEmitterManager.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂service
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜SseSeatService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂session
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂implement
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜SessionManager.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜SessionNotifier.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂service
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜SessionService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂student
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂api
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜StudentPolicyApi.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜StudentProfileApi.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂controller
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜StudentController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜StudentPolicyController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂devtool
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜StudentDataInitializer.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂domain
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Student.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜StudentPolicy.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂dto
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂response
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜StudentCreditRes.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜StudentProfileRes.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂implement
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜StudentAppender.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜StudentPolicyAppender.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜StudentPolicyReader.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜StudentPolicyUpdater.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜StudentReader.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜StudentValidator.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂repository
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜StudentPolicyRepository.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜StudentRepository.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂service
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜StudentService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂type
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜College.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Department.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Major.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜Semester.java
 ┃ ┃ ┃ ┃ ┃ ┗ 📜AllclearWasApplication.java
 ┃ ┃ ┗ 📂resources
 ┃ ┃ ┃ ┣ 📜application.yml
 ┃ ┃ ┃ ┗ 📜data.sql
 ┃ ┗ 📂test
 ┃ ┃ ┗ 📂java
 ┃ ┃ ┃ ┗ 📂com
 ┃ ┃ ┃ ┃ ┗ 📂allclearwas
 ┃ ┃ ┃ ┃ ┃ ┣ 📂domains
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂enrollment
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜EnrollmentServiceTest.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📜AllclearWasApplicationTests.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📜application-test.yml
 ┃ ┃ ┃ ┃ ┃ ┗ 📜TestDatabaseConfig.java
 ┣ 📜.gitattributes
 ┣ 📜.gitignore
 ┣ 📜build.gradle
 ┣ 📜Dockerfile.dev
 ┣ 📜Dockerfile.prod
 ┣ 📜gradlew
 ┣ 📜gradlew.bat
 ┣ 📜README.md
 ┗ 📜settings.gradle
```
