package com.example.cinemawebapp.bootstrap;


import com.example.cinemawebapp.model.*;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {

    public static List<User> userList = new ArrayList<>();
    public static List<Movie> movieList = new ArrayList<>();
    public static List<Auditorium> auditoriumList = new ArrayList<>();
    public static List<Screening> screeningList = new ArrayList<>();
    public static List<Reservation> reservationList = new ArrayList<>();
    public static List<Seat> seatList = new ArrayList<>();
    public static List<Seat_reserved> seat_reservedList = new ArrayList<>();

    @PostConstruct
    public void init(){

    }
}
