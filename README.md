# Spring Basics Training

Spring Boot 기초 역량을 체계적으로 익히기 위한 학습용 레포지토리입니다.  
하나의 프로젝트를 기반으로 아래와 같은 주제를 단계별 브랜치로 구현합니다

---

- 환경/설정: JDK & IDE, 프로젝트 생성, DB 연결

- Java 기반 문법: OOP, 예외 처리, 컬렉션 & 스트림

- Spring Core: DI/IoC, AOP

- Web/MVC: Controller, 요청/응답, ResponseEntity

- DB/JPA: Entity, Repository, CRUD, JPQL

- 트랜잭션/영속성: @Transactional, 1차 캐시

- 보안/인증: Spring Security, JWT

- 테스트/디버깅: JUnit, Logging




# 브랜치별 설명

1. 환경/설정
```java
step1-hello-world → JDK & IDE 세팅, Hello World 출력
step2-jpa-smoketest → Todo 엔티티/레포지토리 추가, SQL 로그 확인
```
2. Java 기반
```java
step3-oop-basics → 클래스, 객체, 상속, 인터페이스, 제네릭 이해
step4-collections-streams → List/Map/Set, Stream filter/map 실습
step5-exception-handling → try-catch, 사용자 정의 예외
```
3. Spring Core
```java
step6-di-ioc → @Component, @Service, @Repository, @Bean, 생성자 주입
step7-aop-basics → @Transactional, 공통 로깅
```
4. Web / MVC
```java
step8-controller-crud → TodoController, REST API 작성 (GET/POST/PUT/DELETE)
step9-request-response → @RequestParam, @PathVariable, @RequestBody
step10-response-entity → ResponseEntity로 상태코드 + JSON 반환
```
5. DB / JPA
```java
step11-entity-repository → 엔티티 + JpaRepository 활용
step12-dto-mapper → DTO 변환 (Entity → DTO)
step13-crud-operations → DB CRUD API 동작 확인 (Postman 테스트)
step14-jpql-basics → JPQL + 페이징/정렬
```
6. 트랜잭션 / 영속성
```java
step15-transactional → commit / rollback 테스트
step16-first-level-cache → 1차 캐시, flush 실습
```

7. 보안 / 인증
```java
step17-security-basics → 로그인/권한 처리
step18-jwt-auth → JWT 발급 & 인증 적용
```

8. 테스트 / 디버깅
```java
step19-junit-tests → 단위 테스트 작성 (Service/Repository)
step20-logging → log.info & SQL 로그 확인
```
