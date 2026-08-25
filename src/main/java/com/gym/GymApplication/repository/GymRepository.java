package com.gym.GymApplication.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.gym.GymApplication.entity.Gym;

public interface GymRepository extends JpaRepository<Gym, Long> {

}