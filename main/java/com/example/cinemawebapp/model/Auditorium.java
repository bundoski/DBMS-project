package com.example.cinemawebapp.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name="auditorium")
public class Auditorium {

    @Id
    @Column(name="id_auditorium")
    Long id_auditorium;
    @Column(name="name_auditorium")
    String name_auditorium;
    @Column(name="num_seats")
    Long num_seats;

    @OneToMany(mappedBy = "auditorium")
    private List<Seat> seatList;

    @OneToMany(mappedBy = "auditorium")
    private List<Screening> screeningList;

    public Auditorium(Long id_auditorium, String name_auditorium, Long num_seats){
        this.id_auditorium = id_auditorium;
        this.name_auditorium = name_auditorium;
        this.num_seats = num_seats;
    }

    public Auditorium() {

    }
}
