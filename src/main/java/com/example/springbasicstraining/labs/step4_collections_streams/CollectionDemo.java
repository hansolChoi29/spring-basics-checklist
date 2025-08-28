package com.example.springbasicstraining.labs.step4_collections_streams;

import java.util.*;

// 컬렉션은 자바에서 데이터를 담는 기본 자료구조라고 생각하면 됨
//List: 순서 있음, 중복 허용
//Set: 순서 없음, 중복 불가
//Map: 키(key) - 값(value) 쌍으로 저장

//즉, 정리하면
//List / Set 은 값만 저장
//Map 은 키와 값 쌍으로 저장
public class CollectionDemo {
    public static void main(String[] args) {
        // List: 순서 o, 중복 o
        List<String> fruits = new ArrayList<>();
        fruits.add("사과");
        fruits.add("바나나");
        fruits.add("사과");
        System.out.println("List: "+fruits);

        //Set: 순서x, 중복x
        Set<String> uniqueFruits = new HashSet<>(fruits);
        System.out.println("Set: "+uniqueFruits);
        
        //Map: key-value쌍
        //key는 중복 불가, value는 중복 가능
        Map<String, Integer> fruitCount = new HashMap<>();
        fruitCount.put("사과", 2);
        fruitCount.put("바나나",2);
        System.out.println("Map: "+fruitCount);
    }
}
