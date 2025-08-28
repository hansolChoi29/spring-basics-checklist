package com.example.springbasicstraining.labs.step7_aop_basics.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access= AccessLevel.PROTECTED)//JPA프록시/리플렉션용
@Entity
@Table(name = "todo_step7")
public class TodoStep7 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    private String title;

    // 생성은 정적 팩토리만 Stter X
    private TodoStep7(String title) {
        this.title = title;
    }

    public  static TodoStep7 create(String title) {
        if(title==null||title.isBlank()) {
            throw new IllegalArgumentException("title must not be blank");
        }
        return new TodoStep7(title.trim());
    }

    public void rename(String oldTitle, String newTitle) {
        if(oldTitle==null||oldTitle.isBlank()) {
            throw new IllegalArgumentException("oldTitle must not be blank");
        }
        this.title=newTitle.trim();
    }
}
