package com.devDJ.cinerma.Entities;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Mejor usar IDENTITY que AUTO
    private Long idSchedule;

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    @ManyToOne
    @JoinColumn(name = "room_id")
    @JsonBackReference("room-schedule") // Referencia única para esta relación
    private Rooms room;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    @JsonBackReference("movie-schedule") // Referencia única para esta relación
    private Movie movie;
}