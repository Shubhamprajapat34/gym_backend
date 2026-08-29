package com.gym.GymApplication.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gym.GymApplication.entity.Diet;
import com.gym.GymApplication.service.DietService;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/diets")
public class DietController {


    private final DietService dietService;

    public DietController(DietService dietService) {
        this.dietService = dietService;
    }

    // CREATE DIET FOR MEMBER
    @PostMapping("/member/{memberId}")
    public Diet createDiet(
            @PathVariable Long memberId,
            @RequestBody Diet diet) {

        return dietService.createDiet(memberId, diet);
    }

    // UPDATE DIET
    @PutMapping("/{dietId}")
    public Diet updateDiet(
            @PathVariable Long dietId,
            @RequestBody Diet diet) {

        return dietService.updateDiet(dietId, diet);
    }

    // GET ALL DIETS OF MEMBER
    @GetMapping("/member/{memberId}")
    public List<Diet> getMemberDiets(
            @PathVariable Long memberId) {

        return dietService.getMemberDiets(memberId);
    }

    // GET ALL DIETS
    @GetMapping
    public List<Diet> getAllDiets() {

        return dietService.getAllDiets();
    }
}