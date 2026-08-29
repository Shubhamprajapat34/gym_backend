package com.gym.GymApplication.service;

import org.springframework.stereotype.Service;

import com.gym.GymApplication.entity.Diet;
import com.gym.GymApplication.entity.Member;
import com.gym.GymApplication.repository.DietRepository;
import com.gym.GymApplication.repository.MemberRepository;

import java.util.List;

@Service
public class DietService {

    private final DietRepository dietRepository;
    private final MemberRepository memberRepository;

    public DietService(
            DietRepository dietRepository,
            MemberRepository memberRepository) {

        this.dietRepository = dietRepository;
        this.memberRepository = memberRepository;
    }

    // CREATE DIET FOR MEMBER
    public Diet createDiet(Long memberId, Diet diet) {

        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new RuntimeException("Member not found"));

        diet.setMember(member);

        return dietRepository.save(diet);
    }

    // UPDATE DIET
    public Diet updateDiet(Long dietId, Diet diet) {

        Diet existingDiet = dietRepository.findById(dietId)
                .orElseThrow(() -> new RuntimeException("Diet not found"));

        existingDiet.setMealType(diet.getMealType());
        existingDiet.setFood(diet.getFood());
        existingDiet.setQuantity(diet.getQuantity());
        existingDiet.setSchedule(diet.getSchedule());

        return dietRepository.save(existingDiet);
    }

    // GET ALL DIETS OF MEMBER
    public List<Diet> getMemberDiets(Long memberId) {

        return dietRepository.findByMemberId(memberId);  // SELECT * FROM dietsWHERE member_id = 6;
    }

    // GET ALL DIETS
    public List<Diet> getAllDiets() {

        return dietRepository.findAll(); 
    }
}
