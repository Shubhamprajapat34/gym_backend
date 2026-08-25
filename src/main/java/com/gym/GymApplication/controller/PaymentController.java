package com.gym.GymApplication.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gym.GymApplication.entity.Payment;
import com.gym.GymApplication.service.PaymentService;

@RestController
@RequestMapping("/api/admin/payments")
@CrossOrigin(origins = "http://localhost:5173")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {

        this.paymentService = paymentService;
    }

    @PostMapping
    public Payment createPayment(
                                @RequestBody Payment payment,
                                @RequestParam Long membershipId) {

        return paymentService.createPayment(
                                    payment,
                                    membershipId );

    }

     @GetMapping
    public List<Payment> getAllPayments() {

        return paymentService.getAllPayments();
    }
}
