package com.gym.GymApplication.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gym.GymApplication.entity.Membership;

public interface MembershipRepository
        extends JpaRepository<Membership, Long> {

    List<Membership> findByMemberId(Long memberId);  // select * from memberships where member_id = ?
    
}
