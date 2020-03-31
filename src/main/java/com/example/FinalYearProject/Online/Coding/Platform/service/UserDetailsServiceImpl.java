package com.example.FinalYearProject.Online.Coding.Platform.service;

import com.example.FinalYearProject.Online.Coding.Platform.dal.UserDetailsDAL;
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
}
