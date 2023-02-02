package com.example.cinemawebapp.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name="seat")
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_seat")
    Long id_seat;
    @Column(name="number_seat")
    Integer number_seat;
    @Column(name="row_seat")
    Integer row_seat;
    @Column(name="id_auditorium")
    Long id_auditorium;

    @ManyToOne
    @JoinColumn(name = "id_auditorium", insertable = false, updatable = false)
    private Auditorium auditorium;

    @OneToMany(mappedBy = "seat")
    private List<Seat_reserved> seat_reservedList;

    public Seat(Long id_seat, Integer number_seat, Integer row_seat, Long id_auditorium){
        this.id_seat = id_seat;
        this.number_seat = number_seat;
        this.row_seat = row_seat;
        this.id_auditorium = id_auditorium;
    }

    public Seat() {

    }
}
