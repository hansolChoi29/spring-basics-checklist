package com.example.springbasicstraining.repository;

import com.example.springbasicstraining.domain.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

// extends JpaRepository
// 엔티티에 대한 CRUD 메서드를 공짜로 제공하는 DB접근 계층임
//한마디로 레포는 DB CRUD도우미 인터페이스.
public interface TodoRepository extends JpaRepository<Todo, Long> {
    // 넣을 수 있는 것들
    //1. 메서드 이름 규칙으로 쿼리 생성
    //2. 페이징 / 정렬
    //3. JPQL/네이티브
    //예시
    // @Query("select t from Todo t where t.title like %:kw%")
    //List<Todo> search(@Param("kw") String kw);
    //4. 카운트/삭제/업데이트 파생쿼리
}
//트랜잭션은 보통 서비스에서 잡고 리포지토리는 쿼리 정의만 맡기는 게 깔끔함(계층분리)