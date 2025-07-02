package com.devDJ.cinerma.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Roles {
    @Id
    @EqualsAndHashCode.Include
    private Integer idRol;

    @Column(nullable = false, length = 50)
    private String name;
    @Column(nullable = false, length = 150)
    private String description;
}
