package com.gym.GymApplication.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "payments")
@Getter
@Setter
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amount;

    private LocalDate paymentDate;

    private String paymentMethod;

    private String status;

    // Payment belongs to one Membership
    @ManyToOne
    @JoinColumn(name = "membership_id", nullable = false)
    private Membership membership;

}
