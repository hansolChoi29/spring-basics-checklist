package com.example.springbasicstraining.labs.step4_collections_streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


// 스트림은 컬렉션/배열 데이터를 가공하는 도구
// 일일이 for문 안쓰고 선언형으로 데이터 처리한다.
//예)배열 → 리스트 변환 후, 필터 + 맵 사용
public class StreamDemo {
    public static void main(String[] args) {
        //배열 -> 리스트 변환
        String[] arr={"apple", "banana", "cherry", "avocado"};
        List<String> fruits= Arrays.asList(arr);
        
        //filter: a로 시작하는 것만 추리기
        List<String> startsWithA = fruits.stream()
                .filter(f -> f.startsWith("a"))
                .collect(Collectors.toList());
        System.out.println("a로 시작하는 과일: " + startsWithA);

        //map: 대문자로 변환
        List<String> upperFruits=fruits.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println("대문자 변환: "+upperFruits);
    }
}
//즉,
// 컬렉션은 데이터를 저장하는 "그릇"
// 스트림은 데이터를 "흐름"으로 처리해서 필터링, 변환, 집계 같은 작업을 쉽게 해주는 "가공도구!"
//그래서 나중에 컬렉션(데이터 저장) + 스트림(데이터 가공) 조합으로 쓰면 됨