package com.gym.GymApplication.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gym.GymApplication.entity.Member;
import com.gym.GymApplication.entity.Membership;
import com.gym.GymApplication.repository.MemberRepository;
import com.gym.GymApplication.repository.MembershipRepository;

import lombok.Getter;
import lombok.Setter;

@Service
@Getter
@Setter
public class MembershipService {

    private final MembershipRepository membershipRepository;
    private final MemberRepository memberRepository;

    public MembershipService(
            MembershipRepository membershipRepository,
            MemberRepository memberRepository) {

        this.membershipRepository = membershipRepository;
        this.memberRepository = memberRepository;
    }

    // CREATE MEMBERSHIP
    public Membership createMembership(
            Membership membership,
            Long memberId) {

        // Find existing member
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Member not found with id: " + memberId
                        ));

        // Connect member with membership
        membership.setMember(member);

        // Save membership
        return membershipRepository.save(membership);
    }
    
     // GET ALL MEMBERSHIPS
    public List<Membership> getAllMemberships() {

        return membershipRepository.findAll();
    }

}
