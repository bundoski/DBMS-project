package com.example.cinemawebapp.web.controller;


import com.example.cinemawebapp.model.Movie;
import com.example.cinemawebapp.model.Reservation;
import com.example.cinemawebapp.service.*;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/reservations")
public class ReservationController {

    private final MovieService movieService;
    private final AuditoriumService auditoriumService;
    private final ScreeningService screeningService;
    private final ReservationService reservationService;
    private final UserService userService;
    private final SeatService seatService;

    @Autowired
    public ReservationController(MovieService movieService, AuditoriumService auditoriumService, ScreeningService screeningService, ReservationService reservationService, UserService userService, SeatService seatService) {
        this.movieService = movieService;
        this.auditoriumService = auditoriumService;
        this.screeningService = screeningService;
        this.reservationService = reservationService;
        this.userService = userService;
        this.seatService = seatService;
    }
}
