package com.gym.GymApplication.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gym.GymApplication.entity.Workout;
import com.gym.GymApplication.service.WorkoutService;

@CrossOrigin(origins = "https://localhost:5173")
@RestController
@RequestMapping("/api/workouts")

public class WorkoutController {

    final WorkoutService workoutService;
    
    public WorkoutController(WorkoutService workoutService) {
        this.workoutService = workoutService;
    }

    // create workout for members 
     @PostMapping("/member/{memberId}")
     public Workout createWorkout(
            @PathVariable Long memberId,
            @RequestBody Workout workout) {

        return workoutService.createWorkout(memberId, workout);
    }
    // update workouts for members
    @PutMapping("/{workoutId}")
    public Workout updateWorkout(
            @PathVariable Long workoutId,
            @RequestBody Workout workout) {

        return workoutService.updateWorkout(workoutId, workout);
    }

    // GET ALL WORKOUTS OF MEMBER
    @GetMapping("/member/{memberId}")
    public List<Workout> getMemberWorkouts(
            @PathVariable Long memberId) {

        return workoutService.getMemberWorkouts(memberId);
    }


}
