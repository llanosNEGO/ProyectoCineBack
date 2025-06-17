package com.devDJ.cinerma.Entities;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
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
    private Long num_rows;  // a base de la cantidad de columas y filas obtnemos la capacidad del cine
    private Long colum;

    //Contructor personalizado para insertar data de prueba
    public Rooms(String name, Long num_rows, Long colum, Cinemas cine) {
        this.name = name;
        this.num_rows = num_rows;
        this.colum = colum;
        this.cine = cine;
    }

    @ManyToOne
    @JoinColumn(name = "cine_id")
    @JsonBackReference
    private Cinemas cine;

    

    
    @OneToMany(mappedBy = "room")
    @JsonBackReference
    private List<Schedule> schedules;

    /*@OneToMany(mappedBy = "room")
    @JsonManagedReference
    private List<Schedule> schedules;*/

}
