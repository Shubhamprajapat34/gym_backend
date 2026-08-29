package com.gym.GymApplication.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gym.GymApplication.entity.Progress;
import com.gym.GymApplication.service.ProgressService;



@RestController
@RequestMapping("/api/progress")
public class ProgressController {
   
  private final ProgressService progressService;

    public ProgressController(
            ProgressService progressService) {

        this.progressService = progressService;
    }

    // CREATE
    @PostMapping("/member/{memberId}")
    public Progress createProgress(
            @PathVariable Long memberId,
            @RequestBody Progress progress) {

        return progressService.createProgress(
                memberId,
                progress);
    }

    // GET ALL
    @GetMapping
    public List<Progress> getAllProgress() {

        return progressService.getAllProgress();
    }

    // GET MEMBER PROGRESS
    @GetMapping("/member/{memberId}")
    public List<Progress> getMemberProgress(
            @PathVariable Long memberId) {

        return progressService.getMemberProgress(
                memberId);
    }

    // UPDATE
    @PutMapping("/{progressId}")
    public Progress updateProgress(
            @PathVariable Long progressId,
            @RequestBody Progress progress) {

        return progressService.updateProgress(
                progressId,
                progress);
    }

}
