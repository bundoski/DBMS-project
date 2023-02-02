package com.example.cinemawebapp.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

@Data
@Entity
@Subselect("SELECT id_screening, COUNT(id_korisnik) as num_reservations FROM reservation GROUP BY id_screening")
@Table(name = "movie_reservation_count")
public class MovieReservationCountView {
    @Id
    @Column(name = "id_screening")
    private int screeningId;

    @Column(name = "num_reservations")
    private int numReservations;
    // getters and setters go here
}


//@Data
//@Entity
//@Table(name="movie_reservation_count")
//@Immutable
//public class MovieReservationCountView {
//
//    @Id
//    @Column(name="id_screening")
//    private int screeningId;
//
//    @Column(name="num_reservations")
//    private int numReservations;
//}
