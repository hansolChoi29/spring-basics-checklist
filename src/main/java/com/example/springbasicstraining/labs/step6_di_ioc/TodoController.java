package com.example.springbasicstraining.labs.step6_di_ioc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {
    private final FakeTodoRepository fakeTodoRepository;
    private final TodoService todoService;

    public TodoController(FakeTodoRepository fakeTodoRepository, TodoService todoService) {
        this.fakeTodoRepository = fakeTodoRepository;
        this.todoService = todoService;
    }

    @GetMapping("/id-test")
    public String getTest(){
        return todoService.processTodo() + ", 저장소 객체 확인: "+fakeTodoRepository.toString();
    }
}

//이전 step까지 CommandLineRunner 로 콘솔 출력만 했는데,
// Controller는 웹 요청을 받아서 실행되도록 만든 것

//차이점
// 1) CommandLineRunner : 애플리케이션 시작 시 자동 실행(콘솔에만 출력)
// 2) RestController : 브라우저/포스트맨에서 url호출할 때 실행(JSON/문자열 응답)

// Spring Bean 라이프사이클(생성부터 소멸까지)
// 생성-> 주입-> 초기화-> 사용-> 소멸 순으로
