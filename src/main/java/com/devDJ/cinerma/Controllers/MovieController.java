package com.devDJ.cinerma.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.devDJ.cinerma.Entities.Movie;
import com.devDJ.cinerma.Repository.IMovieRepository;

@CrossOrigin
@RestController
@RequestMapping("/v1/movies")
public class MovieController {

    @Autowired
    private IMovieRepository movieRepository;

    // Obtener todas las películas (CORRECTO)
    @GetMapping("/pelicula")
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    // Obtener película por ID (CORRECTO)
    @GetMapping("/pelicula/{id}")
    public Movie getMovieById(@PathVariable Long id) {
        return movieRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Película no encontrada"));
    }

    // Crear película (ACTUALIZADO para nuevos campos)
    @PostMapping("/pelicula")
    public Movie createMovie(@RequestBody Movie movie) {
        return movieRepository.save(movie);
    }

    // Actualizar película (AJUSTADO para nuevos campos)
    @PutMapping("/pelicula/{id}")
    public Movie updateMovie(@PathVariable Long id, @RequestBody Movie updatedMovie) {
        return movieRepository.findById(id)
                .map(existingMovie -> {
                    existingMovie.setTitle(updatedMovie.getTitle());
                    existingMovie.setUrl(updatedMovie.getUrl());
                    existingMovie.setSinopsis(updatedMovie.getSinopsis());
                    existingMovie.setGenre(updatedMovie.getGenre());
                    existingMovie.setDirector(updatedMovie.getDirector());
                    existingMovie.setDurationMovie(updatedMovie.getDurationMovie());
                    existingMovie.setAge(updatedMovie.getAge());
                    existingMovie.setUrlTrailer(updatedMovie.getUrlTrailer());
                    existingMovie.setIdioma(updatedMovie.getIdioma());
                    existingMovie.setStatus(updatedMovie.getStatus());
                    existingMovie.setDisponible(updatedMovie.getDisponible());
                    return movieRepository.save(existingMovie);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Película no encontrada"));
    }

    // Eliminar película (CORRECTO)
    @DeleteMapping("/pelicula/{id}")
    public void deleteMovie(@PathVariable Long id) {
        movieRepository.deleteById(id);
    }
}