package com.gym.GymApplication.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "members")
@Getter
@Setter
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    private String phone;

    private String gender;

    private String address;

    private LocalDate joiningDate;

    private String status;

    @ManyToOne
    @JoinColumn(name = "trainer_id")
    private Trainer trainer;

}
