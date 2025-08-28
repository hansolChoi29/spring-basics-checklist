package com.example.springbasicstraining.labs.step5_exceptions;
//2)
//throws 사용: 메서드에서 예외를 던지고 호출한 쪽에서 처리하게 할 수 있음

public class ThrowsExample {
    public static void riskMethod() throws Exception{
        throw new Exception("위험한 동작 발생!");
    }
    public static void main(String[] args) throws Exception{
        try{
            riskMethod();
        }catch(Exception e){
            System.out.println("예외처리: "+e.getMessage());
        }
    }
}
