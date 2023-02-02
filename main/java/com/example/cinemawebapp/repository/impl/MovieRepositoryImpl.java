package com.example.cinemawebapp.repository.impl;

import com.example.cinemawebapp.bootstrap.DataHolder;
import com.example.cinemawebapp.model.Movie;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MovieRepositoryImpl {

    public List<Movie> findAllMovies(){
        return DataHolder.movieList;
    }

    public Optional<Movie> findById(Long movieId){
        return DataHolder.movieList.stream()
                .filter(m -> m.getId_movie().equals(movieId)).findFirst();
    }

    public Optional<Movie> findByName(String name){
        return DataHolder.movieList.stream()
                .filter(m -> m.getTitle_movie().equals(name)).findFirst();
    }

    public void deleteById(Long id){
        DataHolder.movieList.removeIf(i -> i.getId_movie().equals(id));
    }

    public Optional<Movie> save(Long id_movie, String title_movie, String director,
        String description, Long duration_min){
            DataHolder.movieList.removeIf(i -> i.getId_movie().equals(id_movie));
            Movie movie = new Movie(id_movie, title_movie, director, description, duration_min);
            DataHolder.movieList.add(movie);
            return Optional.of(movie);
        }
}
