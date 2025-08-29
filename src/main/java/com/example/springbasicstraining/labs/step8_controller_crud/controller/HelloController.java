package com.example.springbasicstraining.labs.step8_controller_crud.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api") //공통 prefix
public class HelloController {

    //GET요청예제
    @GetMapping("/hello")
    public String hello() {
        return "GET Hello from step8!";
    }

    @PostMapping("/hello")
    public String postHello(@RequestBody String name) {
        return "POST Hello, "+name+"from step8!";
    }
}
// 1) 스레드: nio-8080-exec-1, 서블릿 이름: dispatcherServlet, 초기화 1ms
// 첫 HTTP요청이 들어와서 Spring MVC의 문지기(DispatcherServlet)를 켰다. 준비 끝!
// 터미널에 찍힌
// 1-1) Initializing Spring DispatcherServlet 'dispatcherServlet' : SpringMVC의 문지기를 이제 켠다
// 1-2) Initializing Servlet 'dispatcherServlet' : 진짜로 초기화 중
// 1-3) Completed initialization in 1 ms: 초기화 끝 1ms걸림
// 즉, 이제 컨트롤러 라우팅 할 준비가 끝남

// 2) 왜 config/security가 있는지?
// 2-1) 의존성에 spring-boot-starter-security가 있음.
// 2-2)기본 보안 정책
        //아무 설정 안 해도 다음이 기본으로 걸린다:
        //모든 요청 → 로그인 필요 (401 Unauthorized 발생)
        //기본 계정: user -> 회원가입DB없이도 자동임(임시 개발자 계정)
        //기본 비밀번호: 실행 로그에 찍히는 랜덤 UUID
//2-3) 문제는 단순히 /api/hello 요청을 하고 싶은데 401떠서 귀찮아짐
//2-4) 해결: 시큐리티 컨피그에 anyRequest().permitAll()을 넣어서 모든 요청 허용 → /api/hello 성공.


// 3) 아래 모습으로 반환되는 걸 볼 수 있음
//POST Hello, {
//    "name":"sdf"
//}from step8!
//
// 3-1) why? : DTO를 안써서, public HelloResponse postHello(@RequestBody HelloRequest req) { 형태가 아니라서,
// 컨트롤러에서 String을 그대로 리턴하고 있고 요청 본문을 그냥 문자열로 받아서
// "문자열 + {...} + 문자열" 로 이어 붙였기 때문임
