package com.example.springbasicstraining.labs.step12_dto_mapper.dto;

//서버-> 클라이언트
public record MovieResponse (Long id, String title, String director, Integer year, Double rating) {
}
