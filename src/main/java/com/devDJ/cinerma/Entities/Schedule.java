package com.devDJ.cinerma.Entities;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idSchedule;

    private LocalDateTime startTime; // inico
    private LocalDateTime endTime; // fin

    @ManyToOne
    @JoinColumn(name = "room_id")
    @JsonManagedReference
    private Rooms room;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    @JsonManagedReference
    private Movie movie;

    /*@ManyToOne
    @JoinColumn(name = "room_id")
    @JsonBackReference
    private Rooms room;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    @JsonBackReference
    private Movie movie;*/


}
