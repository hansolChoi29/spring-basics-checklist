package com.example.springbasicstraining.labs.step13_curd_operation.repository;

import com.example.springbasicstraining.labs.step13_curd_operation.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}
