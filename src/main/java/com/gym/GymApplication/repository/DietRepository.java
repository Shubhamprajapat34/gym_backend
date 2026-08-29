package com.gym.GymApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gym.GymApplication.entity.Diet;

import java.util.List;

public interface DietRepository extends JpaRepository<Diet, Long> {

    List<Diet> findByMemberId(Long memberId);   
}