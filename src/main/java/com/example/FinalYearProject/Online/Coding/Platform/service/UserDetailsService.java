package com.example.FinalYearProject.Online.Coding.Platform.service;

import com.example.FinalYearProject.Online.Coding.Platform.domain.User;
import com.example.FinalYearProject.Online.Coding.Platform.domain.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public interface UserDetailsService {
    public Optional<UserDetails> findByUsername(String username);
    public void  increasePoints(String username,int points);
    public void addNewUser(String username, User user);
}
