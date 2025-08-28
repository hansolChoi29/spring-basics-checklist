package com.example.springbasicstraining.oop;
//추상클래스(부모)
public abstract class Vehicle {
    private final String model;
    //공통 속성
    protected Vehicle(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    //공통 행동
    public void start(){
        System.out.println(model+" 시동 ON");
    }

    public abstract int wheelCount();
}

