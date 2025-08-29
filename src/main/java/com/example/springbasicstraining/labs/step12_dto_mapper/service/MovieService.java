package com.example.springbasicstraining.labs.step12_dto_mapper.service;

import com.example.springbasicstraining.labs.step12_dto_mapper.dto.MovieRequest;
import com.example.springbasicstraining.labs.step12_dto_mapper.dto.MovieResponse;
import com.example.springbasicstraining.labs.step12_dto_mapper.entity.Movie;
import com.example.springbasicstraining.labs.step12_dto_mapper.mapper.MovieMapper;
import com.example.springbasicstraining.labs.step12_dto_mapper.repository.MovieRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class MovieService {
    private final MovieRepository movieRepository;
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;

    }

    @Transactional
    public MovieResponse create(MovieRequest movieRequest) {
        Movie saved=movieRepository.save(MovieMapper.toEntity(movieRequest));
        return MovieMapper.toResponse(saved);
    }

    public List<MovieResponse> findAll() {
        return StreamSupport
                .stream(movieRepository.findAll().spliterator(), false)
                .map(MovieMapper::toResponse)
                .toList();
    }

    public MovieResponse findById(Long id) {
        Movie movie=movieRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Movie with id:"+id+" not found"));
        return  MovieMapper.toResponse(movie);
    }
    
    @Transactional
    public MovieResponse updatePatch(Long id, MovieRequest movieRequest) {
        Movie movie=movieRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("영화 못 찾음"+id));
        movie.update(movieRequest.title(),movieRequest.director(),movieRequest.year(), movieRequest.rating());
        return MovieMapper.toResponse(movie);
    }

    @Transactional
    public void deleteById(Long id) {
        if(!movieRepository.existsById(id)){
             throw new EntityNotFoundException("Movie with id:"+id+" not found");
        }
        movieRepository.deleteById(id);
    }
}
