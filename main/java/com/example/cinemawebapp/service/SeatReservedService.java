package com.example.cinemawebapp.service;

import com.example.cinemawebapp.model.Seat;
import com.example.cinemawebapp.model.Seat_reserved;

import java.util.List;
import java.util.Optional;

public interface SeatReservedService {

    List<Seat_reserved> listAll();
    Optional<Seat_reserved> findById(Long seatReservedId);
    Seat_reserved saveSeatReserved(Long id_seat_reserved, Long id_seat, Long id_screening);
    void deleteById(Long seatReservedId);
}
