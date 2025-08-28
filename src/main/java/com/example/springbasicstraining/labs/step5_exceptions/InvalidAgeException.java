package com.example.springbasicstraining.labs.step5_exceptions;
//3-1)
//사용자 정의 예외: 내가 직접 예외 클래스를 만들어서 상황에 맞게 던질 수 있음
public class InvalidAgeException extends RuntimeException{
    public InvalidAgeException(String message){
        super(message);
    }
}
