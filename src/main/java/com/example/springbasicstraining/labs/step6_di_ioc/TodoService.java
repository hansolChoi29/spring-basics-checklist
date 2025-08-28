package com.example.springbasicstraining.labs.step6_di_ioc;

import org.springframework.stereotype.Service;

// 1) 객체 생성
// 1-1) 스프링 컨테이너가 뜨면서 @Component, @Service, @Repository, @Controller 같은 어노테이션을 스캔.
// 1-2) 해당 클래스를 new해서 객체(인스턴스)를 만듦
// 1-3) 이 시점에 Bean이 됨
@Service
public class TodoService {

    private final FakeTodoRepository fakeTodoRepository;
    
    // 2) 의존성 주입(DI)
    // 2-1) 생성된 Bean에 필요한 다른 Bean들을 찾아서 주입해줌(생성자 주입, 세터 주입, 필드 주입)
    // 예) TodoService가 TodoRepository를 필요로 하면 자동으로 연결됨
    public TodoService(FakeTodoRepository fakeTodoRepository) {
        this.fakeTodoRepository = fakeTodoRepository;// 스프링이 자동으로 주입
    }

    //비즈니스 로직 메서드
    public String processTodo(){
        return "서비스 로직-> "+fakeTodoRepository.getTodo();
    }
}

// 서비스가 레포를 직접 new하지 않고
// 스프링 컨테이너가 알아서 넣어줌

// 객체 생명주기 관리(생성~소멸)를 개발자가 아닌 스프링 컨테이너가 담당.
//new TodoService() 같은 걸 안 쓰고 @Service 붙이면 컨테이너가 알아서 Bean으로 관리해줌
// 제어라는 권한이 개발자가 아닌 스프링으로 넘어갔기 때문에 제어의 역전이라고 부름

// 주요 어노테이션의 역할
// 1) @Componenet: 스프링이 관리해야 하는 일반 Bean 클래스
// 2) @Service: 서비스 레이어(비즈니스 로직) Bean
// 3) @Controller/ @RestController: 웹 요청/응답 담당Bean
// 4) @Bean: 개발자가 직접 Bean 등록하고 싶을 때 사용(주로 설정용!, AppConfig같은 클래스에서.)
// -> 다 같은 Bean등록인데, 역할에 따라 의미 부여한 것

// Bean과 어노테이션의 관계
// 어노테이션 붙이면 스프링이 아~ 이 클래스는 Bean등록해야 되겠다하고 관리해줌
// 정리하면, 객체(Object)는 그냥 new해서 만든 일반 자바 인스턴스
// Bean은 스프링 컨테이너가 관리하는 객체.(일반 객체인데 스프링 관리 대상이 됨)
// 어노테이션은 Bean등록해! 라고 스프링에게 알려주는 표시