package com.devDJ.cinerma.dtos;

import lombok.Data;
import java.util.List;

@Data
public class MovieDTO {
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
    private String urlImage;
}