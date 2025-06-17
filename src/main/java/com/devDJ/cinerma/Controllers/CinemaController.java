package com.devDJ.cinerma.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.devDJ.cinerma.Entities.Cinemas;
import com.devDJ.cinerma.Repository.ICinemasRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin
@RestController
@RequestMapping("/v1/cines")
public class CinemaController {

    // inyectar el repository
    @Autowired
    private ICinemasRepository cinemasRepository;

    @GetMapping("/cinemas")
    public List<Cinemas> getCinemas() {
        return cinemasRepository.findAll();
    }

    @GetMapping("/cinema/{id}")
    public Optional<Cinemas> getCinema(@PathVariable Long id) {
        return cinemasRepository.findById(id);
    }

    @PostMapping("/cinema")
    public Cinemas insertCinema(@RequestBody Cinemas cinemas) {
        return cinemasRepository.save(cinemas);
    }

    @PutMapping("/cinema/{id}")
    public Cinemas updateCinema(@PathVariable Long id, @RequestBody Cinemas cinemas) {
        Optional<Cinemas> optionalCinema = cinemasRepository.findById(id);
        if (optionalCinema.isPresent()) {
            Cinemas existingCinema = optionalCinema.get();
            existingCinema.setNameCinema(cinemas.getNameCinema());
            existingCinema.setCity(cinemas.getCity());
            existingCinema.setDescription(cinemas.getDescription());
            existingCinema.setAddress(cinemas.getAddress());
            // Actualiza otras propiedades según sea necesario
            return cinemasRepository.save(existingCinema);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cinema not found");
        }
    }

    @DeleteMapping("/cinema/{id}")
    public ResponseEntity<Void> deleteCinema(@PathVariable Long id) {
        Optional<Cinemas> optionalCinema = cinemasRepository.findById(id);
        if (optionalCinema.isPresent()) {
            cinemasRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cinema not found");
        }
    }
}
