package com.example.springbasicstraining.labs.step5_exceptions;
//1)
// 제일 기본 try-catch

public class TryCatchExample {
    public static void main(String[] args) {
        try{
            int result=10/0;// -> ArithmeticException 발생
            System.out.println("결과: "+result);
        }catch(ArithmeticException e){
            System.out.println("0으로 나눌 수 없습니다.");
        }
        System.out.println("프로그램 계속 실행됨");
    }
}
// 보통 예외처리는 3가지가 있다.

//1) 자바에서 제공하는 예외 클래스를 사용해야 하는데
// NullPointerException (객체가 null인데 메서드 호출 시)
// ArrayIndexOutOfBoundsException (배열 인덱스 범위를 벗어날 때)
// IllegalArgumentException (잘못된 인자를 전달할 때)
// ArithmeticException (0으로 나누기 같은 잘못된 산술 연산)
// 특별한 클래스를 만들지 않아도 바로 던질 수 있다.

//2) 가장 기본적인 예외 처리 방식: try-catch/ throws
//예외를 어떻게 처리 하느냐에 따라 나뉨
// 2-1: try-catch로 잡기 -> 실행 중에 예외가 발생하더라도 프로그램이 강제 종료되지 않고
//                         catch 블록에서 처리 후 정상적으로 계속 진행됨.
// 2-2: throws로 던지기 -> 나는 여기서 처리 안할래~ 호출한 쪽에서 처리해~라는 의미
//                     -> 주로 라이브러리/프레임워크 코드에서 자주 사용됨
//                     -> 호출자가 반드시 try-catch 하거나 또 throws로 떠넘겨야 함

//3) 사용자 정의 예외 - Custom Exception
// 직접 클래스를 만들어서 RuntimeException이나 Exception을 상속받아 작성
// 상황에 맞는 이름/메시지를 가진 예외를 직접 정의할 수 있음

// 정리
// - try-catch : 내가 직접 잡아서 처리
// - throws    : 호출자에게 떠넘김
// - Custom    : 의미 있는 이름/메시지로 직접 정의해서 사용