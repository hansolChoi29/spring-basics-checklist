package com.example.springbasicstraining.labs.step3_oop_basics;
// 자식 클래스(상속+인터페이스 구현)
public class Car extends Vehicle implements Drivable {

    protected Car(String model) {
        super(model);
    }

    @Override
    public void drive() {
        System.out.println(getModel()+"주행 중");
    }

    @Override
    public int wheelCount() {
        return 4; //자동차 4바퀴
    }
}
