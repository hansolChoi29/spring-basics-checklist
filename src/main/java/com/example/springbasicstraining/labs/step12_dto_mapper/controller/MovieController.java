package com.example.springbasicstraining.labs.step12_dto_mapper.controller;

import com.example.springbasicstraining.labs.step12_dto_mapper.dto.MovieResponse;
import com.example.springbasicstraining.labs.step12_dto_mapper.entity.Movie;
import com.example.springbasicstraining.labs.step12_dto_mapper.repository.MovieRepository;
import com.example.springbasicstraining.labs.step12_dto_mapper.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/movies")
public class MovieController {
    private final MovieRepository movieRepository;
    private final MovieService movieService;

    @PostMapping
    public ResponseEntity<Movie> create(@RequestBody Movie movie) {
        return ResponseEntity.ok(movieRepository.save(movie));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long id) {
        return movieRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<MovieResponse>> list() {
        return ResponseEntity.ok(movieService.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movie> update(@PathVariable Long id, @RequestBody Movie movie) {
        try{
            return ResponseEntity.ok(movieRepository.save(movie));
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Movie> patch(@PathVariable Long id, @RequestBody Movie movie) {
        try {
            return ResponseEntity.ok(movieRepository.save(movie));
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id) {
        if(movieRepository.existsById(id)) {
            movieRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }else  {
            return ResponseEntity.notFound().build();
        }
    }

}
