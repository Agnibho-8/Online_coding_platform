package com.example.FinalYearProject.Online.Coding.Platform.service;

import com.example.FinalYearProject.Online.Coding.Platform.domain.Problems;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface ProblemsService {
    public Optional<Problems> findById(int id);
    public List<Problems> findAll();
    public int findPointsByProblemId(int id);
}
