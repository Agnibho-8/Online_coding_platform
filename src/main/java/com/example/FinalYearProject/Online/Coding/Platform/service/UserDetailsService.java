package com.example.FinalYearProject.Online.Coding.Platform.service;

import com.example.FinalYearProject.Online.Coding.Platform.domain.UserDetails;

import java.util.Optional;

public interface UserDetailsService {
    public Optional<UserDetails> findByUsername(String username);
}
