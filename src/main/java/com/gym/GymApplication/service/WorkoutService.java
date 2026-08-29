package com.gym.GymApplication.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gym.GymApplication.entity.Member;
import com.gym.GymApplication.entity.Workout;
import com.gym.GymApplication.repository.MemberRepository;
import com.gym.GymApplication.repository.WorkoutRepository;


@Service
public class WorkoutService {

     private final WorkoutRepository workoutRepository;
    private final MemberRepository memberRepository;

    public WorkoutService(
            WorkoutRepository workoutRepository,
            MemberRepository memberRepository) {
                                        this.workoutRepository = workoutRepository;
                                        this.memberRepository = memberRepository;
    }

    // created work_out plan
    public Workout createWorkout(Long memberId, Workout workout) {
        
         Member member = memberRepository.findById(memberId)
                                         .orElseThrow(() -> new RuntimeException("Member not found"));

        workout.setMember(member);

        return workoutRepository.save(workout);
    }
    // updated work_out  data 
    public Workout updateWorkout(Long workoutId, Workout workout) {

        Workout existingWorkout = workoutRepository.findById(workoutId)
                .orElseThrow(() -> new RuntimeException("Workout not found"));

        existingWorkout.setWorkoutName(workout.getWorkoutName());
        existingWorkout.setDescription(workout.getDescription());
        existingWorkout.setDuration(workout.getDuration());
        existingWorkout.setSchedule(workout.getSchedule());

        return workoutRepository.save(existingWorkout);
    }

    // GET WORKOUTS OF MEMBER BY ID
     public List<Workout> getMemberWorkouts(Long memberId) {

        return workoutRepository.findByMemberId(memberId);
    }
    // GET ALL MEMBERS WORK_OUT
     public List<Workout> getAllWorkouts() {
         return workoutRepository.findAll();
     }
}
