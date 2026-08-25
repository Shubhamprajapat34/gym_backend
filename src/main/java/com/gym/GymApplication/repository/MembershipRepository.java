package com.gym.GymApplication.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.gym.GymApplication.entity.Membership;

public interface MembershipRepository
        extends JpaRepository<Membership, Long> {

}
