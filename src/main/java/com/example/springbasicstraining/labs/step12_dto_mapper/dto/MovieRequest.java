package com.example.springbasicstraining.labs.step12_dto_mapper.dto;

// 클라이언트-> 서버
public record MovieRequest (String title, String director, Integer year, Double rating) {
}
