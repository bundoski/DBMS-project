package com.example.cinemawebapp.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name="seat_reserved")
public class Seat_reserved {

    @Id
    @Column(name="id_seat_reserved")
    Long id_seat_reserved;
    @Column(name="id_seat")
    Long id_seat;
    @Column(name="id_screening")
    Long id_screening;

    @OneToMany(mappedBy = "seat_reserved")
    private List<Reservation> reservationList;

    @ManyToOne
    @JoinColumn(name = "id_screening", insertable = false, updatable = false)
    private Screening screening;

    @ManyToOne
    @JoinColumn(name = "id_seat", insertable = false, updatable = false)
    private Seat seat;

    public Seat_reserved(Long id_seat_reserved, Long id_seat, Long id_screening){
        this.id_seat_reserved = id_seat_reserved;
        this.id_seat = id_seat;
        this.id_screening = id_screening;
    }

    public Seat_reserved() {

    }
}
