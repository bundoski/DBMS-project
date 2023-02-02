package com.example.cinemawebapp.service;

import com.example.cinemawebapp.model.Reservation;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ReservationService {
    List<Reservation> listAll();
    Optional<Reservation> findById(Long reservationId);
    Reservation  saveReservation(Long id_reservation, int active, Integer price_eur, LocalDateTime datum_rezervacija, Long id_korisnik, Long id_seat, Long id_seat_reserved, Long id_screening);
    void deleteById(Long reservationId);

    Reservation save(Reservation reservation);
}
