package com.devDJ.cinerma.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long id_user;
    private String username;
    private String email;
    private String password;
    private List<Integer> rolesId;
}
