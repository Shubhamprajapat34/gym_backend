package com.gym.GymApplication.controller;

import org.springframework.web.bind.annotation.*;

import com.gym.GymApplication.entity.Gym;
import com.gym.GymApplication.service.GymService;

@RestController
@RequestMapping("/api/admin/gym")
@CrossOrigin(origins = "http://localhost:5173")
public class GymController {

    private final GymService gymService;

    public GymController(GymService gymService) {
        this.gymService = gymService;
    }

    // CREATE GYM
    @PostMapping
    public Gym createGym(@RequestBody Gym gym) {

        return gymService.createGym(gym);
    }

    // GET GYM
    @GetMapping("/{id}")
    public Gym getGym(@PathVariable Long id) {

        return gymService.getGym(id);
    }

    // UPDATE GYM
    @PutMapping("/{id}")
    public Gym updateGym(
            @PathVariable Long id,
            @RequestBody Gym gym) {

        return gymService.updateGym(id, gym);
    }
}