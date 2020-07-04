package com.example.FinalYearProject.Online.Coding.Platform.service;

import com.example.FinalYearProject.Online.Coding.Platform.dal.UserDetailsDAL;
import com.example.FinalYearProject.Online.Coding.Platform.domain.User;
import com.example.FinalYearProject.Online.Coding.Platform.domain.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserDetailsDAL dao;
    @Override
    public Optional<UserDetails> findByUsername(String username) {
        return dao.findById(username);
    }

    @Override
    public void increasePoints(String username, int points) {
      int currentPoints = dao.getPointById(username);
      int updatedPoints = currentPoints+points;
        dao.increasePoints(username,updatedPoints);
    }

    @Override
    public void addNewUser(String username, User user) {
        System.out.print("aabba");
        UserDetails obj = new UserDetails(username,0,0,"null");
        System.out.print("aaa");
        dao.save(obj);
    }
}
