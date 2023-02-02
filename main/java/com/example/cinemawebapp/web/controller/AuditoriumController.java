package com.example.cinemawebapp.web.controller;


import com.example.cinemawebapp.model.Auditorium;
import com.example.cinemawebapp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auditoriums")
public class AuditoriumController {

    private final MovieService movieService;
    private final ScreeningService screeningService;
    private final ReservationService reservationService;
    private final UserService userService;
    private final SeatService seatService;
    private final AuditoriumService auditoriumService;

    @Autowired
    public AuditoriumController(AuditoriumService auditoriumService, MovieService movieService, ScreeningService screeningService, ReservationService reservationService, UserService userService, SeatService seatService){
        this.movieService = movieService;
        this.screeningService = screeningService;
        this.reservationService = reservationService;
        this.userService = userService;
        this.seatService = seatService;
        this.auditoriumService = auditoriumService;
    }

    @GetMapping()
    public String getAuditoriumsPage(Model model){
        model.addAttribute("auditoriums", this.auditoriumService.listAll());
        return "listAuditoriums";
    }

    @GetMapping("add-form")
    public String getAddAuditoriumPage(Model model){
        model.addAttribute("list_of_auditoriums", this.auditoriumService.listAll());
        return "add-auditorium";
    }

    @PostMapping("/add")
    public String saveAuditorium(@RequestParam Long id_auditorium,
                                 @RequestParam String name_auditorium,
                                 @RequestParam Long num_seats){
        Auditorium auditorium = new Auditorium(id_auditorium, name_auditorium, num_seats);
        this.auditoriumService.save(auditorium);
        return "redirect:/auditoriums";
    }

    @GetMapping("/edit-form/{id}")
    public String getAuditoriumEditPage(@PathVariable Long id, Model model){
        Auditorium auditorium = this.auditoriumService.findById(id).get();
        model.addAttribute("auditoriumObject", auditorium);
        model.addAttribute("list_of_movies", this.auditoriumService.listAll());
        return "add-auditorium";
    }
}
