package com.example.FinalYearProject.Online.Coding.Platform.service;

import com.example.FinalYearProject.Online.Coding.Platform.domain.Attempts;

import java.util.List;

public interface AttemptsService {
    public Attempts findByUsername(String username);
    public List<Attempts> findaAll();
}
