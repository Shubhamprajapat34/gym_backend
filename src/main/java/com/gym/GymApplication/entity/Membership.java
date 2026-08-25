package com.gym.GymApplication.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "memberships")
public class Membership {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String planName;

    private LocalDate startDate;

    private LocalDate endDate;

    private Double amount;

    private String status;

    // Membership belongs to one Member
    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;


}
