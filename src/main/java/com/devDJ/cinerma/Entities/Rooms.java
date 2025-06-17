package com.devDJ.cinerma.Entities;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Rooms {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idRooms;
    private String name;
    private Long numRows;
    @Column(name = "column_count")
    private Long columnCount;

    public Rooms(String name, Long numRows, Long column, Cinemas cinema) {
        this.name = name;
        this.numRows = numRows;
        this.columnCount = column;
        this.cinema = cinema;
    }

    @ManyToOne
    @JoinColumn(name = "cinema_id")
    @JsonBackReference
    private Cinemas cinema;

    

    
    @OneToMany(mappedBy = "room")
    @JsonManagedReference("room-schedule")
    private List<Schedule> schedules;



}
