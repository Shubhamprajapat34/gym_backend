package com.gym.GymApplication.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "diets")
public class Diet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mealType;

    private String food;

    private String quantity;

    private String schedule;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

}
