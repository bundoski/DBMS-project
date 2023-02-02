package com.example.cinemawebapp.repository.jpa;

import com.example.cinemawebapp.model.Seat;
import com.example.cinemawebapp.model.Seat_reserved;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatReservedRepository extends JpaRepository<Seat_reserved, Long> {
}
