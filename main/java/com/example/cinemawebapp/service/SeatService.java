package com.example.cinemawebapp.service;

import com.example.cinemawebapp.model.Screening;
import com.example.cinemawebapp.model.Seat;
import com.example.cinemawebapp.model.User;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface SeatService {

    List<Seat> listAll();
    Optional<Seat> findById(Long seatId);
    Seat saveSeat(Long id_seat, Integer number_seat, Integer row_seat, Long id_auditorium);
    void deleteById(Long seatId);
}
