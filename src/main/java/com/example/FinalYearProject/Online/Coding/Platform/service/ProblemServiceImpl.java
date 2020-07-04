package com.example.FinalYearProject.Online.Coding.Platform.service;

import com.example.FinalYearProject.Online.Coding.Platform.dal.ProblemsDAL;
import com.example.FinalYearProject.Online.Coding.Platform.domain.Problems;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProblemServiceImpl implements ProblemsService {
    @Autowired
    ProblemsDAL dao;
    @Override
    public Optional<Problems> findById(int id) {
        return dao.findById(id);
    }

    @Override
    public List<Problems> findAll() {
        return dao.findAll();
    }

    @Override
    public int findPointsByProblemId(int id) {
        System.out.println("sds"+id);
        return dao.findPointsByProblemId(id);
    }
}
