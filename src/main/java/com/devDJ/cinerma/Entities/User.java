package com.devDJ.cinerma.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class User {
    @Id
    @EqualsAndHashCode.Include
    private Integer idUser;

    @Column(nullable = false, length = 20)
    private String username;
    @Column(nullable = false, length = 50)
    private String email;
    @Column (nullable = false, length = 60)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role" ,
        joinColumns = @JoinColumn(name = "id_User", referencedColumnName = "idUser"),
            inverseJoinColumns = @JoinColumn(name = "id_role", referencedColumnName = "idRol")
    )
    private List<Roles> roles;

}
