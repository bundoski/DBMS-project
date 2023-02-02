package com.example.cinemawebapp.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name="screening")
public class Screening {

    @Id
    @Column(name="id_screening")
    Long id_screening;
    @Column(name="screening_start")
    LocalDateTime screening_start;
    @Column(name="id_auditorium")
    Long id_auditorium;
    @Column(name="id_movie")
    Long id_movie;

    @OneToMany(mappedBy = "screening")
    private List<Reservation> reservationList;

    @ManyToOne
    @JoinColumn(name = "id_movie", insertable = false, updatable = false)
    private Movie movie;

    @OneToMany(mappedBy = "screening")
    private List<Seat_reserved> seat_reservedList;

    @ManyToOne
    @JoinColumn(name = "id_auditorium", insertable = false, updatable = false)
    private Auditorium auditorium;

    public Screening(Long id_screening, LocalDateTime screening_start,
                     Long id_auditorium, Long id_movie){
        this.id_screening = id_screening;
        this.id_auditorium = id_auditorium;
        this.id_movie = id_movie;
    }

    public Screening() {

    }
}
