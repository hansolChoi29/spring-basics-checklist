package com.example.springbasicstraining.labs.step9_request_response.dto;

public record MemoRequest (String title, String content){
}

// DTO에 public record문법은
// Java 14이상에서 도입된 데이터 전송 클래스 문법임
//생성자, getter, equals, hashCode, toString 같은 거 자동 생성해줌

//원래는
// public class MemoRequest {
//    private String title;
//    private String content;
//
//    public MemoRequest() {} // 기본 생성자 (JSON 역직렬화용)
//
//    public MemoRequest(String title, String content) {
//        this.title = title;
//        this.content = content;
//    }
//
//    public String getTitle() { return title; }
//    public String getContent() { return content; }
//
//    public void setTitle(String title) { this.title = title; }
//    public void setContent(String content) { this.content = content; }
//}
