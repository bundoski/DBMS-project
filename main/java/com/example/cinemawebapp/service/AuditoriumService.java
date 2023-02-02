package com.example.cinemawebapp.service;

import com.example.cinemawebapp.model.Auditorium;
import com.example.cinemawebapp.model.Movie;
import com.example.cinemawebapp.model.User;

import java.util.List;
import java.util.Optional;

public interface AuditoriumService {

    List<Auditorium> findAll();
    List<Auditorium> listAll();
    Optional<Auditorium> findById(Long auditoriumId);
    Optional<Auditorium> findByName(String name);
    // Long id_auditorium, String name_auditorium, Long num_seats
    Auditorium saveAuditorium(Long id_auditorium, String name_auditorium, Long num_seats);
    void deleteById(Long courseId);
    Auditorium save(Auditorium auditorium);
}
