package com.gym.GymApplication.service;

import org.springframework.stereotype.Service;

import com.gym.GymApplication.entity.Member;
import com.gym.GymApplication.entity.Trainer;
import com.gym.GymApplication.repository.MemberRepository;
import com.gym.GymApplication.repository.TrainerRepository;

import java.util.List;

@Service
public class MemberService {
    
    private final MemberRepository memberRepository;
    private final TrainerRepository trainerRepository;

    public MemberService(MemberRepository memberRepository,TrainerRepository trainerRepository) {
        this.memberRepository = memberRepository;
        this.trainerRepository = trainerRepository;
    }

    // Get all members
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    // Get member by ID
    public Member getMemberById(Long id) {
        return memberRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Member not found with id: " + id));
    }

    // Create member
    public Member createMember(Member member) {
         
        if (member.getTrainer() != null &&
            member.getTrainer().getId() != null) {
        Long trainerId = member.getTrainer().getId();
        Trainer trainer = trainerRepository.findById(trainerId)
                .orElseThrow(() ->
                        new RuntimeException("Trainer not found"));

        member.setTrainer(trainer);
    }
        return memberRepository.save(member);
    }

    // Update member
    public Member updateMember(Long id, Member member) {
        
        Member existingMember = getMemberById(id);

        existingMember.setName(member.getName());
        existingMember.setEmail(member.getEmail());
        existingMember.setPhone(member.getPhone());
        existingMember.setGender(member.getGender());
        existingMember.setAddress(member.getAddress());
        existingMember.setJoiningDate(member.getJoiningDate());
        existingMember.setStatus(member.getStatus());

        return memberRepository.save(existingMember);
    }

    // Delete member
    public void deleteMember(Long id) {

        Member member = getMemberById(id);

        memberRepository.delete(member);
    }
}
