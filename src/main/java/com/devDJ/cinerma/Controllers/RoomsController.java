package com.devDJ.cinerma.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devDJ.cinerma.Entities.Rooms;
import com.devDJ.cinerma.Repository.IRoomsRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@CrossOrigin
@RestController
@RequestMapping("/v1/rooms")
public class RoomsController {
    //inyectar el repository
    @Autowired
    private IRoomsRepository roomsRepository;

    @GetMapping("/sala")
    public List<Rooms> getRooms() {
        return roomsRepository.findAll();
    }

    @GetMapping("/sala/{id}")
    public Rooms getRoom(Long id) {
        return roomsRepository.findById(id).orElse(null);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/sala")
    public Rooms insertRoom(@RequestBody Rooms room) {
        return roomsRepository.save(room);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/sala/{id}")
    public void deleteRoom(Long id) {
        roomsRepository.deleteById(id);
    }
}
