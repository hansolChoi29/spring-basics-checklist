package com.example.springbasicstraining.labs.step13_curd_operation.controller;


import com.example.springbasicstraining.labs.step13_curd_operation.entity.Recipe;
import com.example.springbasicstraining.labs.step13_curd_operation.service.RecipsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/recips")
public class RecipsController {
    private RecipsService recipsService;

    @PostMapping
    public ResponseEntity<Recipe> create(@RequestBody Recipe recipe) {
        return ResponseEntity.ok(recipsService.create(recipe));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Recipe> getOne(@PathVariable Long id) {
        return ResponseEntity.ok(recipsService.get(id));
    }
    @GetMapping
    public ResponseEntity<List<Recipe>> getAll() {
        return ResponseEntity.ok(recipsService.getAll());
    }
    @PutMapping("/{id}")
    public ResponseEntity<Recipe> update(@PathVariable Long id, @RequestBody Recipe recipe) {
        return ResponseEntity.ok(recipsService.update(id, recipe));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Recipe> delete(@PathVariable Long id) {
        recipsService.delete(id);
        return ResponseEntity.ok().build();
    }

}
