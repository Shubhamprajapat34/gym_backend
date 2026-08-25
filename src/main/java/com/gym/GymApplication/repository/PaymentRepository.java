package com.gym.GymApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gym.GymApplication.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
