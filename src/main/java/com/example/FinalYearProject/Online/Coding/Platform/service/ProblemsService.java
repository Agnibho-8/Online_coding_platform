package com.example.FinalYearProject.Online.Coding.Platform.service;

import com.example.FinalYearProject.Online.Coding.Platform.domain.Problems;

import java.util.List;
import java.util.Optional;

public interface ProblemsService {
    public Optional<Problems> findById(int id);
    public List<Problems> findAll();
}
