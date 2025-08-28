package com.example.springbasicstraining.labs.step7_aop_basics.repository;

import com.example.springbasicstraining.labs.step7_aop_basics.entity.TodoStep7;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<TodoStep7, Long>{

}
