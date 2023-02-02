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
@Subselect("SELECT k.id_korisnik, k.username, s.id_screening, m.title_movie FROM korisnik k JOIN seat_reserved r ON k.id_korisnik = r.id_korisnik JOIN screening s ON r.id_screening = s.id_screening JOIN movie m ON s.id_movie = m.id_movie")
@Table(name = "movie_user_reservations")
@Immutable
public class MovieUserReservationsView {
    @Id
    @Column(name = "id_korisnik")
    private int userId;

    @Column(name = "username")
    private String username;

    @Column(name = "id_screening")
    private int screeningId;

    @Column(name = "title_movie")
    private String movieTitle;

    // getters and setters go here
}



//@Entity
//@Table(name="movie_user_reservations")
//@Immutable
//public class MovieUserReservationsView {
//
//    @Id
//    @Column(name="id_korisnik")
//    private int userId;
//
//    @Column(name="username")
//    private String username;
//    @Column(name = "id_screening")
//    private int screeningId;
//    @Column(name = "title_movie")
//    private String movieTitle;
//
//}
