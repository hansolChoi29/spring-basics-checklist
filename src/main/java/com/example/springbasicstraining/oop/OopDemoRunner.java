package com.example.springbasicstraining.oop;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//실행해서 콘솔로 확인(CommandLineRunner)
@Component
public class OopDemoRunner implements CommandLineRunner {
    @Override
    public void run(String... args){
        Car car=new Car("아반떼");

        car.start();
        System.out.println("바퀴 수: "+car.wheelCount());

        car.drive();

        Box<String> box=new Box<>("헬로 오오피");
        System.out.println("박스 내용: "+box.get());
    }
}
