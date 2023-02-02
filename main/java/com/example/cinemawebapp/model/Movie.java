package com.example.cinemawebapp.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name="movie")
public class Movie {

    @Id
    @Column(name="id_movie")
    Long id_movie;
    @Column(name="title_movie")
    String title_movie;
    @Column(name="director")
    String director;
    @Column(name="description")
    String description;
    @Column(name="duration_min")
    Long duration_min;

    @OneToMany(mappedBy = "movie")
    private List<Screening> screeningList;

    public Movie(Long id_movie, String title_movie, String director,
                 String description, Long duration_min){
        this.id_movie = id_movie;
        this.title_movie = title_movie;
        this.director = director;
        this.description = description;
        this.duration_min = duration_min;
    }

    public Movie() {

    }
}
