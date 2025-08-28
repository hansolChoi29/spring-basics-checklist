package com.example.springbasicstraining.domain;
// @Entity
// DDD 철학에서는 entity라는 기술적 분류 보단, 도메인(업무개념)을 기준으로 묶는 걸 권장하기 때문에 entity패키지 안만듦
// 즉, 엔티티는 기술적으로 엔티티지만, 더 중요한 건 할 일 이라는 도메인객체라는 점.

//그래서 domain.투두.투두가 더 직관적이고 나중에 서비스/리포지토리/DTO도 같은 도메인 이름으로 패키지 묶을 수 있음

import jakarta.persistence.*;

@Entity
@Table(name="todos")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//IDENTITY=AUTO_INCREMENT
    private Long id;

    @Column(nullable = false)
    private String title;

    protected Todo(){
        // JPA가 내부적으로 객체를 만들 때
        //리플랙션을 쓰는데, 파라미터 없는 생성자가 반드시 있어야 함
        //protected를 쓰면 외부 남용은 막으면서 JPA는 사용 가능함
        }
    public Todo(String title){
        this.title = title;
    }
    public Long getId(){return id;}
    public String getTitle(){return title;}
}
