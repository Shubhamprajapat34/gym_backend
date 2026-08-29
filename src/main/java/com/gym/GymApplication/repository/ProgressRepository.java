package com.gym.GymApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gym.GymApplication.entity.Progress;

import java.util.List;

public interface ProgressRepository
        extends JpaRepository<Progress, Long> {

    List<Progress> findByMemberId(Long memberId); // findi all the record belong to this member records

    // ex = slect * from progress where member id = ?
}