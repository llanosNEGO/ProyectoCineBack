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

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Cinemas {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long idCinemas;
    @Column
    private String nameCinema;
    @Column
    private String description;
    @Column
    private String address;

    //Contructor personalizado para llenar los datos cine
    public Cinemas(String nameCinema, String description, String address, Cities city) {
        this.nameCinema = nameCinema;
        this.description = description;
        this.address = address;
        this.city = city;
    }


    /********************************Relaciones con otras tablas****************************** */
    //muchos cines estan relacionados con una ciudad
    @ManyToOne
    @JoinColumn(name = "city_id")
    @JsonBackReference
    private Cities city;

    //Un cine Tine muchas salas y una sala pertenece a un cine
    @OneToMany(mappedBy = "cine", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Rooms> rooms;

}
