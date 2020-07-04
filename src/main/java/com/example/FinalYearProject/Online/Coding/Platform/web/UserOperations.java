package com.example.FinalYearProject.Online.Coding.Platform.web;

import com.example.FinalYearProject.Online.Coding.Platform.domain.Problems;
import com.example.FinalYearProject.Online.Coding.Platform.domain.UserProblemID;
import com.example.FinalYearProject.Online.Coding.Platform.service.ProblemsService;
import com.example.FinalYearProject.Online.Coding.Platform.service.SolvedProblemsByUserService;
import com.example.FinalYearProject.Online.Coding.Platform.service.UserDetailsService;
import com.example.FinalYearProject.Online.Coding.Platform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Component
public class UserOperations {
    public static String currentUsername;
    @Autowired
    UserDetailsService userDetailsService;
    @Autowired
    ProblemsService problemsService;
    @Autowired
    SolvedProblemsByUserService solvedProblemsByUserService;
    public void setCurrentUsername(String currentUsername) {
        UserOperations.currentUsername = currentUsername;
    }
    protected  void increasePoint(int problemId){
        System.out.println("sad2");
        //if the user has solved the problem previously
        if(solvedProblemsByUserService.isSolved(currentUsername,problemId)){
            return;
        }
        int points = problemsService.findPointsByProblemId(problemId);
        System.out.println("sad"+points);
        userDetailsService.increasePoints(currentUsername,points);
        solvedProblemsByUserService.addSolved(currentUsername,problemId);
    }
    protected void addUserProblemID(String username){
        System.out.println(username);
        solvedProblemsByUserService.addUser(username);
    }
}
