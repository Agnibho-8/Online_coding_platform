package com.example.FinalYearProject.Online.Coding.Platform.service;

import com.example.FinalYearProject.Online.Coding.Platform.domain.ProblemDetails;
import com.example.FinalYearProject.Online.Coding.Platform.domain.ProblemTestCaseId;

import java.util.List;
import java.util.Optional;

public interface ProblemDetailsService {
    public Optional<ProblemDetails> findById(ProblemTestCaseId id);
    public List<ProblemDetails> findAll();
}
