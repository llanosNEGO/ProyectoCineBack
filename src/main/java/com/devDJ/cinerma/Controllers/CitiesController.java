package com.devDJ.cinerma.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


import com.devDJ.cinerma.Entities.Cities;
import com.devDJ.cinerma.Repository.ICitiesRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@CrossOrigin
@RestController
@RequestMapping("/v1/cities")
public class CitiesController {

    // inyectar el repository
    @Autowired
    private ICitiesRepository citiesRepository;

    @GetMapping("/city")
    public List<Cities> getCities() {
        return citiesRepository.findAll();
    }

    @GetMapping("/city/{id}")
    public Cities getCity(@PathVariable Long id) {
        return citiesRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "City not found"));
    }

    @PostMapping("/city")
    public Cities inserCity(@RequestBody Cities city) {
       return citiesRepository.save(city);
    }


    @PutMapping("/city/{id}")
    public Cities updateCity(@PathVariable Long id, @RequestBody Cities city) {
        Optional<Cities> optionalCity = citiesRepository.findById(id);
        if (optionalCity.isPresent()) {
            Cities existingCity = optionalCity.get();
            existingCity.setNameCity(city.getNameCity());
            // Actualiza otras propiedades según sea necesario
            return citiesRepository.save(existingCity);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "City not found");
        }
    }

    @DeleteMapping("/city/{id}")
    public void deleteCity(@PathVariable Long id) {
        citiesRepository.deleteById(id);
    }
}
