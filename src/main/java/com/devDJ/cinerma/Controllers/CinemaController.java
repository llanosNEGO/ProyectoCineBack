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
    private ICinemasRepository cinemasRepository;

    @GetMapping
    public List<Cinemas> getAllCinemas() {
        return cinemasRepository.findAll();
    }

    @GetMapping("/{id}")
    public Cinemas getCinemaById(@PathVariable Long id) {
        return cinemasRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cine no encontrado"));
    }

    @PostMapping
    public Cinemas createCinema(@RequestBody Cinemas cinema) {
        return cinemasRepository.save(cinema);
    }

    @PutMapping("/{id}")
    public Cinemas updateCinema(@PathVariable Long id, @RequestBody Cinemas updatedCinemas) {
        return cinemasRepository.findById(id)
                .map(existingCinema -> {
                    existingCinema.setName(updatedCinemas.getName());
                    existingCinema.setDescription(updatedCinemas.getDescription());
                    existingCinema.setAddress(updatedCinemas.getAddress());
                    existingCinema.setUrlImage(updatedCinemas.getUrlImage());
                    existingCinema.setHorarios(updatedCinemas.getHorarios());
                    existingCinema.setDisponible(updatedCinemas.getDisponible());
                    existingCinema.setCities(updatedCinemas.getCities());
                    return cinemasRepository.save(existingCinema);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cine no encontrado"));
    }

    @DeleteMapping("/{id}")
    public void deleteCinema(@PathVariable Long id) {
        cinemasRepository.deleteById(id);
    }
}