package com.devDJ.cinerma.Controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import com.devDJ.cinerma.Entities.Cities;
import com.devDJ.cinerma.Repository.ICitiesRepository;

@CrossOrigin
@RestController
@RequestMapping("/v1/cities")
public class CitiesController {

    @Autowired
    private ICitiesRepository cityRepository;

    @GetMapping
    public List<Cities> getAllCities() {
        return cityRepository.findAll();
    }

    @GetMapping("/{id}")
    public Cities getCityById(@PathVariable Long id) {
        return cityRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Ciudad no encontrada"));
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public Cities createCity(@RequestBody Cities cities) {
        return cityRepository.save(cities);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/{id}")
    public Cities updateCity(@PathVariable Long id, @RequestBody Cities updatedCity) {
        return cityRepository.findById(id)
                .map(existingCity -> {
                    existingCity.setName(updatedCity.getName());
                    return cityRepository.save(existingCity);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Ciudad no encontrada"));
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/{id}")
    public void deleteCity(@PathVariable Long id) {
        cityRepository.deleteById(id);
    }
}