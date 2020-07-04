package com.example.FinalYearProject.Online.Coding.Platform.service;

import com.example.FinalYearProject.Online.Coding.Platform.dal.SolvedProblemByUserDAL;
import com.example.FinalYearProject.Online.Coding.Platform.domain.SolvedProblemsByUser;
import com.example.FinalYearProject.Online.Coding.Platform.domain.UserProblemID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class SolvedProblemsByUserImpl implements SolvedProblemsByUserService {
    @Autowired
    SolvedProblemByUserDAL dao;
    @Override
    public void addSolved(String username, int problemId) {
        UserProblemID userProblemID = new UserProblemID(username,problemId);
        SolvedProblemsByUser obj = new SolvedProblemsByUser(userProblemID,true);
        dao.save(obj);
    }

    @Override
    public boolean isSolved(String username, int problemId) {
        UserProblemID userProblemID = new UserProblemID(username,problemId);
    return dao.isSolved(userProblemID);
    }

    @Override
    public void addUser(String username) {
        System.out.println(username);
        for(int i=1;i<=10;i++){
            UserProblemID userProblemID = new UserProblemID(username,i);
            SolvedProblemsByUser solvedProblemsByUser = new SolvedProblemsByUser(userProblemID,false);
            dao.save(solvedProblemsByUser);
        }
    }
}
