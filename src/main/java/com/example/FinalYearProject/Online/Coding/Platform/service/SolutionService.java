package com.example.FinalYearProject.Online.Coding.Platform.service;

import com.example.FinalYearProject.Online.Coding.Platform.domain.Solution;

import java.util.Optional;

public interface SolutionService {
    public Optional<Solution> findByProblemId(int problemId);
}
