package com.gym.GymApplication.controller;


import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gym.GymApplication.entity.Membership;
import com.gym.GymApplication.service.MembershipService;

@CrossOrigin(origins = "http://localhost:5173") 
@RestController
@RequestMapping("/api/memberships")
public class MembershipController {

    private final MembershipService membershipService;

    public MembershipController(
            MembershipService membershipService) {

        this.membershipService = membershipService;
    }
     // CREATE
    @PostMapping
    public Membership createMembership(
            @RequestBody Membership membership,@RequestParam Long memberId) {

        return membershipService.createMembership(membership,memberId);
    }

    // GET ALL
    @GetMapping
    public List<Membership> getAllMemberships() {

        return membershipService.getAllMemberships();
    }

    @GetMapping("/member/{memberId}")
    public List<Membership> getMembershipsByMember(
        @PathVariable Long memberId) {

    return membershipService.getMembershipsByMember(memberId);
   }

   
}
