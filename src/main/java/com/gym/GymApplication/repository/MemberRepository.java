package com.gym.GymApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gym.GymApplication.entity.Member;

public interface MemberRepository
        extends JpaRepository<Member, Long> {
            
}
