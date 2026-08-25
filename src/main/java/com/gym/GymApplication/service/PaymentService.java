package com.gym.GymApplication.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gym.GymApplication.entity.Membership;
import com.gym.GymApplication.entity.Payment;
import com.gym.GymApplication.repository.MembershipRepository;
import com.gym.GymApplication.repository.PaymentRepository;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final MembershipRepository membershipRepository;

    public PaymentService(
            PaymentRepository paymentRepository,
            MembershipRepository membershipRepository) {

        this.paymentRepository = paymentRepository;
        this.membershipRepository = membershipRepository;
    }

    // ==================================
    // CREATE PAYMENT
    // ==================================

    public Payment createPayment(
            Payment payment,
            Long membershipId) {

        // Find existing membership
        Membership membership =
                membershipRepository.findById(membershipId)
                                    .orElseThrow(() -> new RuntimeException(
                                        "Membership not found with id: "+ membershipId
                                      ));

        // Connect membership with payment
        payment.setMembership(membership);

        // Save payment
        return paymentRepository.save(payment);
    }

     // GET ALL PAYMENTS

    public List<Payment> getAllPayments() {

        return paymentRepository.findAll();
    }
}
