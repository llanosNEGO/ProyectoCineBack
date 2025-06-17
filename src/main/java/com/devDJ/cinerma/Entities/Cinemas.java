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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;          // Ej: "CP Alcazar"
    private String description;   // "descripcion 1"
    private String address;       // "Av. Santa Cruz 814-816"
    private String urlImage;      // URL del logo del cine
    private List<String> horarios; // ["5:00 pm", "8:30 pm"]
    private List<String> disponible; // ["2D", "REGULAR"]

    // Relación con Ciudad (1 cine pertenece a 1 ciudad)
    @ManyToOne
    @JoinColumn(name = "city_id")
    @JsonBackReference
    private Cities cities;

    // Relación con Salas (1 cine tiene muchas salas)
    @OneToMany(mappedBy = "cinema", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Rooms> rooms; // Antes "sala" en el JSON

}
