package com.example.cinemawebapp.service.impl;


import com.example.cinemawebapp.model.Movie;
import com.example.cinemawebapp.model.exception.MovieAlreadyExistsException;
import com.example.cinemawebapp.model.exception.MovieNotFoundException;
import com.example.cinemawebapp.repository.jpa.MovieRepository;
import com.example.cinemawebapp.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Movie> findAll() {
        return this.movieRepository.findAll();
    }


    @Override
    public List<Movie> listAll() {
        return this.movieRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(Movie::getTitle_movie)).
                collect(Collectors.toList());
    }

    @Override
    public Optional<Movie> findById(Long movieId) {
        if(this.movieRepository.findById(movieId).isEmpty()){
            throw new MovieNotFoundException();
        }
        return this.movieRepository.findById(movieId);
    }

    @Override
    public Optional<Movie> findByName(String name) {
        return this.movieRepository.findByName(name);
    }

    @Override
    public Movie saveMovie(Long id_movie, String title_movie, String director, String description, Long duration_min) {
        if(id_movie != null && findById(id_movie).isPresent()){
            Movie movie = this.movieRepository.findById(id_movie).orElseThrow(MovieNotFoundException::new);
            movie.setId_movie(id_movie);
            movie.setTitle_movie(title_movie);
            movie.setDirector(director);
            movie.setDescription(description);
            movie.setDuration_min(duration_min);
            return movieRepository.save(movie);
        }
        else if(id_movie != null && findByName(title_movie).isPresent() && findById(id_movie).isEmpty()){
            throw new MovieAlreadyExistsException(title_movie);
        }

        return movieRepository.save(new Movie(id_movie, title_movie, director, description, duration_min));
    }
    @Override
    public Movie save (Movie movie){
        Movie m = new Movie(movie.getId_movie(), movie.getTitle_movie(), movie.getDirector()
        , movie.getDescription(), movie.getDuration_min());
        return this.movieRepository.save(m);
    }

    @Override
    public void deleteById(Long movieId) {
        this.movieRepository.deleteById(movieId);
    }

    @Override
    public void removeMovie(Long id) {
        Movie movie = movieRepository.findById(id).get();
       this.movieRepository.delete(movie);
    }


}
