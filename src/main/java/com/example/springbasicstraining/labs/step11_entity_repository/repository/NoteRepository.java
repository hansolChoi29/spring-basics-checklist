package com.example.springbasicstraining.labs.step11_entity_repository.repository;

import com.example.springbasicstraining.labs.step11_entity_repository.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;

//JpaRepository<엔티티, ID타입> 상속하면
//save() → INSERT / UPDATE
//findById() → PK로 조회
//delete() / deleteById() → 삭제
//findAll() → 전체조회
// 자동으로 제공받을 수 있다. 지금은 필요없음
public interface NoteRepository extends JpaRepository<Note ,Long> {
}
//save → 엔티티 저장
//findById → 없는 ID 조회 시 Optional.empty() 반환
//delete → 존재하지 않는 ID 삭제 시 예외 없이 무시됨
//existsById → 삭제 전에 존재 여부 체크할 수 있음