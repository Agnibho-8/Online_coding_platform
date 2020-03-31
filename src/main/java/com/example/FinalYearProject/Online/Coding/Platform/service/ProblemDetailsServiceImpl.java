package com.example.FinalYearProject.Online.Coding.Platform.service;

import com.example.FinalYearProject.Online.Coding.Platform.dal.ProblemsDetailsDAL;
import com.example.FinalYearProject.Online.Coding.Platform.domain.ProblemDetails;
import com.example.FinalYearProject.Online.Coding.Platform.domain.ProblemTestCaseId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProblemDetailsServiceImpl implements ProblemDetailsService {

   @Autowired
   ProblemsDetailsDAL dao;
    @Override
    public Optional<ProblemDetails> findById(ProblemTestCaseId id) {
        return dao.findById(id);
    }

    @Override
    public List<ProblemDetails> findAll() {
        return dao.findAll();
    }
}
