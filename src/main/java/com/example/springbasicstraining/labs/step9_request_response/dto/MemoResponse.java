package com.example.springbasicstraining.labs.step9_request_response.dto;
// 응답 DTO (객체 → JSON)
public record MemoResponse(Long Id, String title, String content) {
}
