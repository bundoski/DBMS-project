package com.example.cinemawebapp.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.Subselect;

@Data
@Entity
@Subselect("SELECT m.title_movie, m.director, m.duration_min FROM movie m")
@Table(name = "prikaz_filmovi")
public class PrikazFilmoviView {
    @Id
    @Column(name = "title_movie")
    private String title;

    @Column(name = "director")
    private String director;

    @Column(name = "duration_min")
    private int duration;

    // getters and setters go here
}