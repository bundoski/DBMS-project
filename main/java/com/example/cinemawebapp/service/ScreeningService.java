package com.example.cinemawebapp.service;

import com.example.cinemawebapp.model.Movie;
import com.example.cinemawebapp.model.Reservation;
import com.example.cinemawebapp.model.Screening;
import com.example.cinemawebapp.model.User;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ScreeningService {

    List<Screening> listAll();
    Optional<Screening> findById(Long screeningId);
    Screening saveScreening(Long id_screening, LocalDateTime screening_start,
                            Long id_auditorium, Long id_movie);
    void deleteById(Long screeningId);
}
