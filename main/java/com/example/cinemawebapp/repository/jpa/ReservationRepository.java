package com.example.cinemawebapp.repository.jpa;

import com.example.cinemawebapp.model.Reservation;
import com.example.cinemawebapp.model.Screening;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
   // public Optional<Reservation> saveReservation(Long id_reservation, int active, Integer price_eur, LocalDateTime datum_rezervacija, Long id_korisnik, Long id_seat, Long id_seat_reserved, Long id_screening);
}
