package com.example.springbasicstraining.labs.step6_di_ioc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//CommandLineRunner 실행
@Component
public class DiIocDemoRunner implements CommandLineRunner {
    private final TodoService todoService;
    private final String appName;

    public DiIocDemoRunner(TodoService todoService, String appName) {
        this.todoService = todoService;
        this.appName = appName;
    }

    @Override
    public void run(String... args) {
        System.out.println("DI/IoC 실습 시~작!");
        System.out.println(todoService.processTodo());
        System.out.println("앱 이름: "+appName);
    }
}
