package com.example.cinemawebapp.model.exception;

public class AuditoriumAlreadyExistsException extends RuntimeException {

    public AuditoriumAlreadyExistsException(String name){
        super("The auditorium with name" + name + " does not exist");
    }
}
