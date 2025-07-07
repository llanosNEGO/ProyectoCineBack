package com.devDJ.cinerma.dtos;

import lombok.Data;
import java.util.List;

@Data
public class MovieResponseDTO {
    private Long idMovie;
    private String title;
    private String sinopsis;
    private String director;
    private String genre;
    private String durationMovie;
    private String age;
    private List<String> idioma;
    private List<String> status;
    private List<String> disponible;
    private String urlTrailer;
    private String urlImage; // Campo adicional para la imagen principal
    private String imageCard; // Usado en el frontend (opcional)
    private String imageDetails; // Usado en el frontend (opcional)
}