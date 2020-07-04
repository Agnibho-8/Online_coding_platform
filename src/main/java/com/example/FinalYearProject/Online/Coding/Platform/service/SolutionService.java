package com.example.FinalYearProject.Online.Coding.Platform.service;

import com.example.FinalYearProject.Online.Coding.Platform.domain.Solution;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public interface SolutionService {
    public Optional<Solution> findByProblemId(int problemId);
}
