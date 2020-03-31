package com.example.FinalYearProject.Online.Coding.Platform.service;

import com.example.FinalYearProject.Online.Coding.Platform.dal.SolutionDAL;
import com.example.FinalYearProject.Online.Coding.Platform.domain.Solution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class SolutionServiceImpl implements SolutionService {
   @Autowired
    SolutionDAL dao;
    @Override
    public Optional<Solution> findByProblemId(int problemId) {
        return dao.findById(problemId);
    }
}
