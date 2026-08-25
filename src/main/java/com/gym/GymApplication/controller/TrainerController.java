package com.gym.GymApplication.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gym.GymApplication.entity.Trainer;
import com.gym.GymApplication.service.TrainerService;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/admin/trainers")
public class TrainerController {

    private final TrainerService trainerService;

    public TrainerController(TrainerService trainerService) {
        this.trainerService = trainerService;
    }

    // GET all trainers
    @GetMapping
    public List<Trainer> getAllTrainers() {
        return trainerService.getAllTrainers();
    }

    // GET trainer by ID
    @GetMapping("/{id}")
    public Trainer getTrainerById(@PathVariable Long id) {
        return trainerService.getTrainerById(id);
    }

    // CREATE trainer
    @PostMapping
    public Trainer createTrainer(@RequestBody Trainer trainer) {
        return trainerService.createTrainer(trainer);
    }

    // UPDATE trainer
    @PutMapping("/{id}")
    public Trainer updateTrainer(
            @PathVariable Long id,
            @RequestBody Trainer trainer) {

        return trainerService.updateTrainer(id, trainer);
    }

    // DELETE trainer
    @DeleteMapping("/{id}")
    public String deleteTrainer(@PathVariable Long id) {

        trainerService.deleteTrainer(id);

        return "Trainer deleted successfully";
    }
}