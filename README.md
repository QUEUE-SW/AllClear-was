## AllClear Was

---

## 🧭 프로젝트 소개
> AllClear-Was은 **QUEUE-SW 프로젝트의 백엔드 서버**로,  
대규모 트래픽 환경에서 안정적인 수강신청을 지원합니다.  
스프링 기반의 구조와 병렬 분산 처리 기술을 활용하여 높은 동시성과 안정성을 제공하며, 프론트엔드와 연동되어 수강신청 대기열 관리, 인증/인가, 데이터 처리 등을 담당합니다.

---

## 🛠️ 기술 스택

|영역|사용 기술|설명|
|-|-|-|
|**언어**|Java 17|안정성과 성능, 스프링 프레임워크와의 높은 호환성|
|**프레임워크**|Spring Boot|빠른 설정, 구조화된 개발, REST API 제작 용이|
|**빌드 도구**|Gradle|빌드 속도와 유연한 설정, 의존성 관리 용이|
|**데이터베이스**|MySQL (RDS)|트랜잭션 보장, 관계형 구조에 적합, AWS RDS로 관리 편리|
|**캐시 서버**|Redis|실시간 여석 조회 성능 개선, 메모리 기반 저장소로 빠른 응답 가능|
|**인프라**|AWS EC2, Docker|유연한 배포/확장, 컨테이너화로 통합 환경 일관성 확보|
|**배포**|GitHub Actions|CI/CD 자동화 구현|
|**성능 테스트**|JMeter|트래픽 시나리오 구성 및 시각화에 유리, 다양한 플러그인 지원|
|**통신 방식**|REST API, Polling, SSE|API 기반 통신, Polling은 간단한 대기열 확인 방식, SSE는 대기열 실시간 통신에 적합|
|**협업 도구**|Jira, Confluence, Slack|애자일 기반 태스크 관리, 문서 공유 및 팀원 간 실시간 커뮤니케이션|

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
