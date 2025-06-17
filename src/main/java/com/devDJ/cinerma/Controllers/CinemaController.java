package com.devDJ.cinerma.Controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import com.devDJ.cinerma.Entities.Cinemas;
import com.devDJ.cinerma.Repository.ICinemasRepository;

@CrossOrigin
@RestController
@RequestMapping("/v1/cinemas")
public class CinemaController {

    @Autowired
    private ICinemasRepository cinemaRepository;

    @GetMapping
    public List<Cinemas> getAllCinemas() {
        return cinemaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Cinemas getCinemaById(@PathVariable Long id) {
        return cinemaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cine no encontrado"));
    }

    @PostMapping
    public Cinemas createCinema(@RequestBody Cinemas cinema) {
        return cinemaRepository.save(cinema);
    }

    @PutMapping("/{id}")
    public Cinemas updateCinema(@PathVariable Long id, @RequestBody Cinemas updatedCinema) {
        return cinemaRepository.findById(id)
                .map(existingCinema -> {
                    existingCinema.setName(updatedCinema.getName());
                    existingCinema.setDescription(updatedCinema.getDescription());
                    existingCinema.setAddress(updatedCinema.getAddress());
                    existingCinema.setUrlImage(updatedCinema.getUrlImage());
                    existingCinema.setHorarios(updatedCinema.getHorarios());
                    existingCinema.setDisponible(updatedCinema.getDisponible());
                    existingCinema.setCities(updatedCinema.getCities());
                    return cinemaRepository.save(existingCinema);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cine no encontrado"));
    }

    @DeleteMapping("/{id}")
    public void deleteCinema(@PathVariable Long id) {
        cinemaRepository.deleteById(id);
    }
}