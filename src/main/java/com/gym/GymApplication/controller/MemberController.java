package com.gym.GymApplication.controller;

import org.springframework.web.bind.annotation.*;

import com.gym.GymApplication.entity.Member;
import com.gym.GymApplication.service.MemberService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/admin/members")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    // GET all members
    @GetMapping
    public List<Member> getAllMembers() {
        return memberService.getAllMembers();
    }

    // GET member by ID
    @GetMapping("/{id}")
    public Member getMemberById(@PathVariable Long id) {
        return memberService.getMemberById(id);
    }

    // CREATE member
    @PostMapping
    public Member createMember(@RequestBody Member member) {
        return memberService.createMember(member);
    }

    // UPDATE member
    @PutMapping("/{id}")
    public Member updateMember(
            @PathVariable Long id,
            @RequestBody Member member) {

        return memberService.updateMember(id, member);
    }

    // DELETE member
    @DeleteMapping("/{id}")
    public String deleteMember(@PathVariable Long id) {

        memberService.deleteMember(id);

        return "Member deleted successfully";
    }
}