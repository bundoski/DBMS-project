package com.example.cinemawebapp.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name="korisnik")
public class User {

    @Id
    @Column(name="id_korisnik")
    Long id;
    @Column(name="username")
    String username;
    @Column(name="lozinka")
    String password;

    @OneToMany(mappedBy = "korisnik")
    private List<Reservation> reservations;

     public User(Long id, String username, String password){
         this.id = id;
         this.username = username;
         this.password = password;
     }

    public User() {

    }
}
