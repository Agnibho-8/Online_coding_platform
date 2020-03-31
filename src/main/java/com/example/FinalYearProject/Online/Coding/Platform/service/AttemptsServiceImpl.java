package com.example.FinalYearProject.Online.Coding.Platform.service;

import com.example.FinalYearProject.Online.Coding.Platform.dal.AttemptsDAL;
import com.example.FinalYearProject.Online.Coding.Platform.domain.Attempts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AttemptsServiceImpl implements AttemptsService {
   @Autowired
    AttemptsDAL dao;

    @Override
    public Attempts findByUsername(String username) {
        return dao.findByUsername(username);
    }

    @Override
    public List<Attempts> findaAll() {
        return dao.findAll();
    }
}
