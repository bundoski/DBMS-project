package com.example.cinemawebapp.repository.jpa;

import com.example.cinemawebapp.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<Seat, Long> {
}
