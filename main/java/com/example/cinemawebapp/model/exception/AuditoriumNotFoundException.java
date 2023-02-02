package com.example.cinemawebapp.model.exception;

public class AuditoriumNotFoundException extends RuntimeException {

    public AuditoriumNotFoundException(){
        super("Error 404: Auditorium not found");
    }
}
