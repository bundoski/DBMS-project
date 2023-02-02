package com.example.cinemawebapp.service;

import com.example.cinemawebapp.model.Auditorium;
import com.example.cinemawebapp.model.Movie;
import com.example.cinemawebapp.model.User;

import java.util.List;
import java.util.Optional;

public interface MovieService {

    List<Movie> findAll();
    List<Movie> listAll();
    Optional<Movie> findById(Long movieId);
    Optional<Movie> findByName(String name);
    Movie saveMovie(Long id_movie, String title_movie, String director, String description, Long duration_min);

    Movie save(Movie movie);

    void deleteById(Long movieId);

    void removeMovie(Long id);
}
