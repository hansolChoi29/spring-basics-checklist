package com.example.springbasicstraining.labs.step12_dto_mapper.repository;

import com.example.springbasicstraining.labs.step12_dto_mapper.entity.Movie;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<Movie, Long> {
}
