package com.gym.GymApplication.service;


import org.springframework.stereotype.Service;

import com.gym.GymApplication.entity.Gym;
import com.gym.GymApplication.repository.GymRepository;

@Service
public class GymService {

    private final GymRepository gymRepository;

    public GymService(GymRepository gymRepository) {
        this.gymRepository = gymRepository;
    }

    // CREATE
    public Gym createGym(Gym gym) {

        return gymRepository.save(gym);
    }

    // GET
    public Gym getGym(Long id) {

        return gymRepository.findById(id)
                            .orElseThrow(() -> new RuntimeException(
                                   "Gym not found with id: " + id
                             ));
    }

    // UPDATE
    public Gym updateGym(Long id, Gym gym) {

        Gym existingGym = gymRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Gym not found with id: " + id
                        ));

        existingGym.setName(gym.getName());
        existingGym.setAddress(gym.getAddress());
        existingGym.setPhone(gym.getPhone());
        existingGym.setEmail(gym.getEmail());
        existingGym.setOpeningTime(gym.getOpeningTime());
        existingGym.setClosingTime(gym.getClosingTime());

        return gymRepository.save(existingGym);
    }
}
