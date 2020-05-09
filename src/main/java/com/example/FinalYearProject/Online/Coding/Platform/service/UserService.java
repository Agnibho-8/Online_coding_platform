package com.example.FinalYearProject.Online.Coding.Platform.service;

import com.example.FinalYearProject.Online.Coding.Platform.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public String addNewUser(User toBeAdded);
    public void removeExisting(String username);
    public String findPasswords(String username);
    public List<User> findAll();
}
