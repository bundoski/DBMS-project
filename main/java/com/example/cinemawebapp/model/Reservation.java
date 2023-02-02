package com.example.cinemawebapp.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name="reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_reservation")
    Long id_reservation;
    @Column(name="active")
    int active;
    @Column(name="price_eur")
    Integer price_eur;
    @Column(name="datum_rezervacija")
    LocalDateTime datum_rezervacija;
    @Column(name="id_korisnik")
    Long id_korisnik;
    @Column(name="id_seat")
    Long id_seat;
    @Column(name="id_seat_reserved")
    Long id_seat_reserved;
    @Column(name="id_screening")
    Long id_screening;

    @ManyToOne
    @JoinColumn(name="id_korisnik", insertable = false, updatable = false)
    private User korisnik;

    @ManyToOne
    @JoinColumn(name = "id_seat_reserved", insertable = false, updatable = false)
    private Seat_reserved seat_reserved;

    @ManyToOne
    @JoinColumn(name = "id_screening", insertable = false, updatable = false)
    private Screening screening;

    public Reservation(Long id_reservation, int active, Integer price_eur, LocalDateTime datum_rezervacija, Long id_korisnik, Long id_seat, Long id_seat_reserved, Long id_screening) {
        this.id_reservation = id_reservation;
        this.active = active;
        this.price_eur = price_eur;
        this.datum_rezervacija = datum_rezervacija;
        this.id_korisnik = id_korisnik;
        this.id_seat = id_seat;
        this.id_seat_reserved = id_seat_reserved;
        this.id_screening = id_screening;
    }

    public Reservation() {

    }

}
