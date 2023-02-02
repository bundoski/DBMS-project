package com.example.cinemawebapp.model.exception;

public class MovieNotFoundException extends RuntimeException{

    public MovieNotFoundException(){
        super("Error 404: Movie does not exist");
    }
}
