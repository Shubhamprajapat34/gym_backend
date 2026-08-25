package com.gym.GymApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gym.GymApplication.entity.Trainer;

public interface TrainerRepository
        extends JpaRepository<Trainer, Long> {
}
