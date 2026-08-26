package com.gym.GymApplication.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.gym.GymApplication.entity.Workout;

import java.util.List;


public interface WorkoutRepository extends JpaRepository<Workout, Long> {

    List<Workout> findByMemberId(Long memberId);
}