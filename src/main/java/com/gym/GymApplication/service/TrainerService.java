package com.gym.GymApplication.service;

import org.springframework.stereotype.Service;
import com.gym.GymApplication.entity.Trainer;
import com.gym.GymApplication.repository.TrainerRepository;

import java.util.List;

@Service
public class TrainerService {

    private final TrainerRepository trainerRepository;

    public TrainerService(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    // Get all trainers
    public List<Trainer> getAllTrainers() {
        return trainerRepository.findAll();
    }

    // Get trainer by ID
    public Trainer getTrainerById(Long id) {
        return trainerRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Trainer not found with id: " + id));
    }

    // Create trainer
    public Trainer createTrainer(Trainer trainer) {
        return trainerRepository.save(trainer);
    }

    // Update trainer
    public Trainer updateTrainer(Long id, Trainer trainer) {

        Trainer existingTrainer = getTrainerById(id);

        existingTrainer.setName(trainer.getName());
        existingTrainer.setEmail(trainer.getEmail());
        existingTrainer.setPhone(trainer.getPhone());
        existingTrainer.setSpecialization(trainer.getSpecialization());
        existingTrainer.setExperience(trainer.getExperience());
        existingTrainer.setStatus(trainer.getStatus());

        return trainerRepository.save(existingTrainer);
    }

    // Delete trainer
    public void deleteTrainer(Long id) {

        Trainer trainer = getTrainerById(id);

        trainerRepository.delete(trainer);
    }
}