package com.devDJ.cinerma.Entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Cities {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCities;
    private String nameCity;
    
    /*********************************Relaciones con otras tablas**********************/
    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Cinemas> cines;

    public Cities(String nameCity) {
        this.nameCity = nameCity;
    }
}
