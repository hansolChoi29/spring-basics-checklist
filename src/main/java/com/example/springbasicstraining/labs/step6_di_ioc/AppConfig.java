package com.example.springbasicstraining.labs.step6_di_ioc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//Bean이란? 스프링 컨테이너가 관리하는 객체
// 그냥 new해서 만든 객체랑 다르게, 스프링이 직접 만들고 주입해주고 소명까지 관리하는 특별한 객체.

//@Configuration은 설정 클래스라는 뜻
//안에 @Bean을 붙이면 스프링 컨테이너가 직접 관리하는 객체(Bean)로 등록해 줌
// 즉, String appName() 리턴값이 SpringBasicsTraning -DI/IoC 실습-> 이 문자열이 Bean이 돼서 다른 클래스(DiIocDemoRunner)의 생성자에서 String appName으로 주입 받을 수 있는 거임
@Configuration
public class AppConfig {
    //Bean을 안 붙이면 일반 메서드일 뿐, 스프링 컨테이너가 관리하지 않음-> 생성자 주입 불가능해짐
    //따라서 Bean 반드시 있어야 함
    @Bean
    public String appName(){
        return "SpringBasicsTraning - DI/IoC 실습";
    }
}

// 자동 등록이 불가능한 객체가 존재함.
// 외부 라이브러리 객체, 단순값, 혹은 커스터마이징한 객체.
// 이런 경우 AppConfig같은 설정 클래스에서 직접 @Bean으로 등록해줌
// = appName이라는 이름의 Bean을 등록해줘! 나중에 필요하면 생성자 주입으로 가져다 써!
