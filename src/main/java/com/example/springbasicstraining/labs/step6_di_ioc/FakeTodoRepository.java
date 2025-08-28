package com.example.springbasicstraining.labs.step6_di_ioc;

import org.springframework.stereotype.Repository;

@Repository
public class FakeTodoRepository {
    public String getTodo(){
        return "DI/IoC 실습 중~: 할 일 가져오기";
    }
}
