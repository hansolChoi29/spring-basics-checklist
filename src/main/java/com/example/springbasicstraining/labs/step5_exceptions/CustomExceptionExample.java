package com.example.springbasicstraining.labs.step5_exceptions;
//3-2)
public class CustomExceptionExample {
    public static void main(String[] args) {
        int age = -5;
        try {
            if (age < 0) {
                throw new InvalidAgeException("나이는 음수가 될 수 없음");
            }
            System.out.println("정상 실행됨");
        } catch (InvalidAgeException e) {
            System.out.println("[예외 발생] " + e.getMessage());
        }
    }
}
