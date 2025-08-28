package com.example.springbasicstraining;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBasicsTrainingApplication  implements CommandLineRunner {

    public static void main(String[] args) {
        System.out.println("Hello World1");
        SpringApplication.run(SpringBasicsTrainingApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello World2");
    }
}
//출력결과
//Hello World1
//Hello World1
//실행
//Hello World2 가 찍힘

//이유
// Hello Wolrd1은 main() 안에서 찍는 로그.
//spring-boot-devtools는 앱을 한 번 켠 다음에 재시작 모드로 한 번 더 킴(main()2번 호출됨)
// 그래서 main()이 두 번 실행됨.
// Hello Wolrd2는
// CommandLineRunner 동작원리: 스프링 컨텍스트가 다 준비된 뒤 실행됨
//DevTools가 재시작 모드를 만들더라도 최종저긍로 컨텍스트 완성 시점에서 딱 한번만 실행.
// 스프링 전부 준비된 뒤에 실행되는 코드임
//앱이 다 올라간 뒤에 한 번만 찍힘


//즉,
//main() 앞쪽 로그 = 부트스트랩 + 재시작 두 번
//CommandLineRunner#run() 로그 = 컨텍스트 완성 후 한 번