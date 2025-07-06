package com.devDJ.cinerma.services;

import com.devDJ.cinerma.Entities.Movie;
import com.devDJ.cinerma.Repository.IMovieRepository;
import com.devDJ.cinerma.dtos.*;
import com.devDJ.cinerma.exceptions.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService {

    @Autowired
    private IMovieRepository movieRepository;

    @Autowired
    private ModelMapper modelMapper;

    // Crear película
    public MovieResponseDTO createMovie(MovieDTO movieDTO) {
        Movie movie = modelMapper.map(movieDTO, Movie.class);
        Movie savedMovie = movieRepository.save(movie);
        return modelMapper.map(savedMovie, MovieResponseDTO.class);
    }

    // Obtener todas
    public List<MovieResponseDTO> getAllMovies() {
        return movieRepository.findAll().stream()
                .map(movie -> modelMapper.map(movie, MovieResponseDTO.class))
                .collect(Collectors.toList());
    }

    // Obtener por ID
    public MovieResponseDTO getMovieById(Long id) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Película no encontrada con ID: " + id));
        return modelMapper.map(movie, MovieResponseDTO.class);
    }

    // Actualizar
    public MovieResponseDTO updateMovie(Long id, MovieDTO movieDTO) {
        Movie existingMovie = movieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Película no encontrada con ID: " + id));
        modelMapper.map(movieDTO, existingMovie);
        Movie updatedMovie = movieRepository.save(existingMovie);
        return modelMapper.map(updatedMovie, MovieResponseDTO.class);
    }

    // Eliminar
    public void deleteMovie(Long id) {
        if (!movieRepository.existsById(id)) {
            throw new ResourceNotFoundException("Película no encontrada con ID: " + id);
        }
        movieRepository.deleteById(id);
    }
}