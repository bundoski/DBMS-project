package com.example.cinemawebapp.web.controller;


import com.example.cinemawebapp.model.Movie;
import com.example.cinemawebapp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;
    private final AuditoriumService auditoriumService;
    private final ScreeningService screeningService;
    private final ReservationService reservationService;
    private final UserService userService;
    private final SeatService seatService;

    @Autowired
    public MovieController(MovieService movieService, AuditoriumService auditoriumService, ScreeningService screeningService, ReservationService reservationService, UserService userService, SeatService seatService) {
        this.movieService = movieService;
        this.auditoriumService = auditoriumService;
        this.screeningService = screeningService;
        this.reservationService = reservationService;
        this.userService = userService;
        this.seatService = seatService;
    }

    @GetMapping()
    public String getMoviesPage(@RequestParam(required=false) String error, Model model){
        model.addAttribute("list_of_movies", this.movieService.listAll());
        return "listMovies";
    }

    @GetMapping("add-form")
    public String getAddMoviePage(Model model){
        model.addAttribute("list_of_movies", this.movieService.listAll());
        model.addAttribute("list_of_auditoriums", this.auditoriumService.listAll());
        model.addAttribute("list_of_seats", this.seatService.listAll());
        return "add-movie";
    }

    @PostMapping("/add")
    public String saveMovie(@RequestParam Long id_movie,
                            @RequestParam String title_movie,
                            @RequestParam String director,
                            @RequestParam String description,
                            @RequestParam Long duration_min
    ){
        Movie movie = new Movie(id_movie, title_movie, director, description, duration_min);
        this.movieService.save(movie);
        return "redirect:/movies";
    }

    @GetMapping("/edit-form/{id}")
    public String getMoviesEditPage(@PathVariable Long id, Model model){
            Movie movie = this.movieService.findById(id).get();
            model.addAttribute("movieObject", movie);
            model.addAttribute("list_of_auditoriums", this.auditoriumService.listAll());
            return "redirect:/movies/add-form";

    }

    @PostMapping("/delete/{id}")
    public String deleteMovie(@PathVariable Long id){
        this.movieService.removeMovie(id);
        return "redirect:/movies";
    }

}
