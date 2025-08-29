package com.example.springbasicstraining.labs.step13_curd_operation.service;


import com.example.springbasicstraining.labs.step13_curd_operation.entity.Recipe;
import com.example.springbasicstraining.labs.step13_curd_operation.repository.RecipeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RecipsService {
    private final RecipeRepository repo;
    // CREATE
    public Recipe create(Recipe recipe) {
        return repo.save(recipe);
    }

    // READ
    public Recipe get(Long id) {
        return repo.findById(id).orElseThrow();
    }

    public List<Recipe> getAll() {
        return repo.findAll();
    }

    // UPDATE
    public Recipe update(Long id, Recipe update) {
        Recipe r = repo.findById(id).orElseThrow();
        r.setName(update.getName());
        r.setIngredients(update.getIngredients());
        r.setInstructions(update.getInstructions());
        return r;
    }

    // DELETE
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
