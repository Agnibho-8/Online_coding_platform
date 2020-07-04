package com.example.FinalYearProject.Online.Coding.Platform.service;

import com.example.FinalYearProject.Online.Coding.Platform.domain.SolvedProblemsByUser;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public interface SolvedProblemsByUserService {
    public void addSolved(String username, int problemId);
    public boolean isSolved(String username, int problemId);
    public void addUser(String username);
}
