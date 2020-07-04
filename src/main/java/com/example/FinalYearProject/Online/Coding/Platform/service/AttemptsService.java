package com.example.FinalYearProject.Online.Coding.Platform.service;

import com.example.FinalYearProject.Online.Coding.Platform.domain.Attempts;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface AttemptsService {
    public Attempts findByUsername(String username);
    public List<Attempts> findaAll();
}
