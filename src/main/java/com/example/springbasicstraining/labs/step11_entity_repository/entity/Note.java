package com.example.springbasicstraining.labs.step11_entity_repository.entity;

import jakarta.persistence.*;

@Entity
public class Note {
    //@GeneratedValue → PK 자동 생성 (IDENTITY, AUTO, SEQUENCE 등 전략 선택 가능)

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // 1) IDENTITY:MySQL에서 주로 씀, DB가 알아서 1, 2, 3… 이렇게 번호를 붙여줌,엔티티 저장할 때 INSERT 실행해야만 id 값이 생김.
    // 2) AUTO :그냥 “DB 맞춰 알아서 해줘” 옵션임.
    // MySQL → IDENTITY
    // Oracle/Postgres → SEQUENCE
    // 3) SEQUENCE : Oracle, PostgreSQL 같은 DB는 SEQUENCE라는 별도 객체가 있어서 번호를 뽑아줌, PA는 그 시퀀스를 이용해서 id를 만듦.
    // (SEQUENCE 예시)
            //    @Id
            //    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "note_seq")
            //    @SequenceGenerator(name = "note_seq", sequenceName = "note_seq", allocationSize = 1)
            //    private Long id;
    // => 한 세트임

    private String title;
    private String content;
    
    protected Note() {} //JPA 기본 생성자 필수임

    public Note(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
}
