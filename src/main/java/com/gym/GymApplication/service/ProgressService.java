package com.gym.GymApplication.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gym.GymApplication.entity.Member;
import com.gym.GymApplication.entity.Progress;
import com.gym.GymApplication.repository.MemberRepository;
import com.gym.GymApplication.repository.ProgressRepository;

@Service
public class ProgressService {

     private final ProgressRepository progressRepository;
    private final MemberRepository memberRepository;

    public ProgressService(
            ProgressRepository progressRepository,
            MemberRepository memberRepository) {

        this.progressRepository = progressRepository;
        this.memberRepository = memberRepository;
    }

    // CREATE PROGRESS
    public Progress createProgress(Long memberId,
                                   Progress progress) {

        Member member = memberRepository.findById(memberId)
                                        .orElseThrow(() ->new RuntimeException("Member not found"));
        progress.setMember(member);
        return progressRepository.save(progress);
    }

    // GET ALL PROGRESS
    public List<Progress> getAllProgress() {

        return progressRepository.findAll();
    }

    // GET PROGRESS OF ONE MEMBER
    public List<Progress> getMemberProgress(Long memberId) {

        return progressRepository.findByMemberId(memberId);
    }

    // UPDATE PROGRESS
    public Progress updateProgress(
            Long progressId,
            Progress progress) {

        Progress existingProgress =
                progressRepository.findById(progressId)
                                  .orElseThrow(() -> new RuntimeException("Progress not found"));

        existingProgress.setWeight(progress.getWeight());
        existingProgress.setHeight(progress.getHeight());
        existingProgress.setBodyFat(progress.getBodyFat());
        existingProgress.setProgressDate(progress.getProgressDate());

        return progressRepository.save(
                existingProgress);
    }
}
