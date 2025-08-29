package com.example.springbasicstraining.labs.step12_dto_mapper.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Movie {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String director;
    private Integer year;
    private Double rating;

    protected Movie() {}

    public Movie(String title, String director, Integer year, Double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
    }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getDirector() { return director; }
    public Integer getYear() { return year; }
    public Double getRating() { return rating; }

    public void update(String title, String director, Integer year, Double rating) {
     if(title!=null) this.title=title;
     if(director!=null) this.director=director;
     if(year!=null) this.year=year;
     if(rating!=null) this.rating=rating;
    }
}
//Entity = DB와 맞추기 위한 설계도
//DTO = 클라이언트와 맞추기 위한 설계도

//Entity ↔ DTO 변환을 자주 해야 함.
//Controller: 클라이언트 → DTO → Entity 변환 필요
//Service/Repository: Entity → DTO 변환 필요
//만약 Mapper가 없으면,
//Controller/Service 코드 안에 변환 로직이 흩어짐.
//중복 코드가 많이 생김.
//그래서 변환을 한 곳에 모아두는 클래스가 Mapper.


// 코드 흐름
//Controller (API 요청/응답)
//   ↓ DTO 변환
//Service (비즈니스 로직)
//   ↓ Entity ↔ DTO 변환
//Repository (DB 접근)
//   ↓ Entity
//DB
