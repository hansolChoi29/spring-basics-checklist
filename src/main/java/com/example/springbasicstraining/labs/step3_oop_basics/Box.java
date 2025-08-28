package com.example.springbasicstraining.labs.step3_oop_basics;

// 제네릭 클래스
//어떤 타입이든 담을 수 있는 상자
public class Box<T> {
    private T value;

    public Box(){}
    public Box(T value){
        this.value=value;
    }
    public void set(T value){
        this.value=value;
    }

    public T get() {
        return value;
    }
}
