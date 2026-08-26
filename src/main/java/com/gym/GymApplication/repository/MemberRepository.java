package com.gym.GymApplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gym.GymApplication.entity.Member;

public interface MemberRepository
        extends JpaRepository<Member, Long> {
           
      List<Member> findByTrainerId(Long trainerId);   // select * from member where trainer_id = ?
}
