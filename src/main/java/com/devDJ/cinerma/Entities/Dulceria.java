package com.devDJ.cinerma.Entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Dulceria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ElementCollection
    private List<String> description; // Ej: ["1 Canchita Gigante", "2 Bebidas"]

    private Double cost;
    private String category;
    private String urlImage;
}