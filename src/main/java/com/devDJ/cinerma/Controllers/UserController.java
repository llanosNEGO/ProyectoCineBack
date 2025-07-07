package com.devDJ.cinerma.Controllers;

import com.devDJ.cinerma.Entities.Roles;
import com.devDJ.cinerma.Entities.User;

import com.devDJ.cinerma.Repository.IRolRepository;
import com.devDJ.cinerma.Repository.IUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IRolRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User userRequest) {
        try {
            // 1. Validar datos de entrada
            if (userRequest.getEmail() == null || userRequest.getPassword() == null) {
                return ResponseEntity.badRequest().body("Email y password son requeridos");
            }

            // 2. Verificar si el email ya existe
            if (userRepository.existsByEmail(userRequest.getEmail())) {
                return ResponseEntity.status(HttpStatus.CONFLICT)
                        .body("El email ya está registrado");
            }

            // 3. Obtener rol USER
            Roles userRole = roleRepository.findByName("USER")
                    .orElseThrow(() -> new RuntimeException("Rol USER no encontrado"));

            // 4. Crear nuevo usuario
            User newUser = new User();
            newUser.setUsername(userRequest.getUsername());
            newUser.setEmail(userRequest.getEmail());
            newUser.setPassword(passwordEncoder.encode(userRequest.getPassword()));
            newUser.setRoles(List.of(userRole));

            // 5. Guardar usuario
            User savedUser = userRepository.save(newUser);

            // 6. Retornar respuesta (sin password)
            savedUser.setPassword(null);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);

        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body("Error al registrar usuario: " + e.getMessage());
        }
    }
}