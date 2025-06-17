package com.devDJ.cinerma.Entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idMovie;

    private String title;
    private String url; // Imagen del poster (nuevo campo)
    private String sinopsis;
    private String genre;
    private String director;
    private String durationMovie; // Cambiado de "duration" a "durationMovie"
    private String age; // Cambiado de "int" a "String" (ej: "+14")
    private String urlTrailer;

    // Listas (antes eran List<String>)
    @ElementCollection
    private List<String> idioma; // ["SUBTITULADA", "DOBLADA"]

    @ElementCollection
    private List<String> status; // ["Cartelera"]

    @ElementCollection
    private List<String> disponible; // ["REGULAR", "2D", "3D"]

    // Relación con Schedule (sin cambios)
    @OneToMany(mappedBy = "movie")
    @JsonBackReference
    private List<Schedule> schedules;
}
