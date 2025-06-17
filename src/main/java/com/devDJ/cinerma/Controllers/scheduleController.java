package com.devDJ.cinerma.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devDJ.cinerma.Entities.Schedule;
import com.devDJ.cinerma.Repository.IScheduleRepository;

@CrossOrigin
@RestController
@RequestMapping("/v1/shedule")
public class scheduleController {
     @Autowired
    private IScheduleRepository scheduleRepository;
    
    @GetMapping("/cronograma")
    public List<Schedule> getSchedule() {
        return scheduleRepository.findAll();
    }

    @GetMapping("/cronograma/{id}")
    public ResponseEntity<Schedule> getSchedule(@PathVariable Long id) {
        return scheduleRepository.findById(id)
                .map(schedule -> ResponseEntity.ok().body(schedule))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping("/cronograma")
    public Schedule insertSchedule(@RequestBody Schedule schedule) {
        return scheduleRepository.save(schedule);
    }
}
