package com.example.springbasicstraining.labs.step13_curd_operation.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "recipes")
public class Recipe {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String ingredients; //달걀, 우유, 설탕
    
    @Column(length = 4000)
    private String instructions; //조리방법

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Difficulty difficulty = Difficulty.EASY;

    @Column(nullable = false, updatable = false)
    private LocalDateTime creatAt;

    @Column(nullable = false)
    private LocalDateTime updateAt;

    private Integer cookingTimeMinutes;
    protected Recipe(){}

    public Recipe(String name, String ingredient, String instructions, Difficulty difficulty, Integer cookingTimeMinutes) {
        this.name = name;
        this.ingredients = ingredient;
        this.instructions = instructions;
       this.cookingTimeMinutes = cookingTimeMinutes;
       if(difficulty!=null) this.difficulty = difficulty;
    }

    @PrePersist
    void onCreate() {
        this.creatAt = LocalDateTime.now();
        this.updateAt = LocalDateTime.now();
    }

    @PreUpdate
    void onUpdate() {
        this.updateAt = LocalDateTime.now();
    }

    // Getter/Setter
    public Long getId() { return id; }
    public String getName() { return name; }
    public String getIngredients() { return ingredients; }
    public String getInstructions() { return instructions; }

    public void setName(String name) { this.name = name; }
    public void setIngredients(String ingredients) { this.ingredients = ingredients; }
    public void setInstructions(String instructions) { this.instructions = instructions; }
}

// 스키마 제약
//@Column(nullable = false) → DB에서 NOT NULL 제약 생성
//@Column(unique = true) → 중복 불가
//@Id → PRIMARY KEY 테이블에서 행(row)을 구분하는 유일한 값
//FOREIGN KEY 다른 테이블과 연결(참조 무결성 보장)