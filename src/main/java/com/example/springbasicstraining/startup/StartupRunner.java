package com.example.springbasicstraining.startup;

import com.example.springbasicstraining.domain.Todo;
import com.example.springbasicstraining.repository.TodoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

// @Component + CommandLineRunner
//클래스 용도 : DB 스모크 테스트용
@Component
public class StartupRunner implements CommandLineRunner {
    //CommandLineRunner는 스프링이 앱을 다 띄운 후 바로 실행할 코드를 쓰고 싶을때.
    //스프링이 약속한 후처리 훅 인터페이스 구현해야 됨.
    
    // 생성자 주입
    private final TodoRepository todoRepository;
    public StartupRunner(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }
    @Override
    public void run(String... args){
        todoRepository.save(new Todo("첫 번째 할 일"));
        System.out.println("투두 카운트: "+todoRepository.count());
    }
}
// startup은 걍 앱 시작할 때 한 번 돌릴 코드들 넣고자 만듦
//앱이 켜질 때 스모크 테스트(DB되는지, 기본 데이터 넣기 등)를 자동으로 해보려는 용도

//실무에서는 보통 초기데이터는 마이그레이션 도구(Flyway/Liquibase)로 넣는 걸 권장함
//즉, 학습 단계라서 "시작 시 자동으로 실행하는 자리로 임시 사용" 스모크테스트

//출력결과
//Hibernate: insert into todos (title) values (?)
//Hibernate: select count(*) from todos t1_0
//투두 카운트: 13
// 위 1,2번째 출력결과는 프로퍼티의
//spring.jpa.show-sql: true
//logging.level.org.hibernate.SQL: debug
//logging.level.org.hibernate.orm.jdbc.bind: trace
//로 인해 출력됨.