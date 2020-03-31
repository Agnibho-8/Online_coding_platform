package com.example.FinalYearProject.Online.Coding.Platform.service;

import com.example.FinalYearProject.Online.Coding.Platform.dal.UserDAL;
import com.example.FinalYearProject.Online.Coding.Platform.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDAL dao;

    @Override
    public String addNewUser(User toBeAdded) {
        User saved = dao.save(toBeAdded);
        return saved.getUsername();
    }

    @Override
    public void removeExisting(String username) {
        Optional<User> existing = dao.findById(username);
            dao.deleteById(username);
       }

    @Override
    public Optional<User> findByUsername(String username) {
       return dao.findById(username);

    }

    @Override
    public List<User> findAll() {
        return dao.findAll();
    }
}
