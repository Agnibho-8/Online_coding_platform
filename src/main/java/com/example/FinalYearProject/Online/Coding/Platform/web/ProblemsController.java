package com.example.FinalYearProject.Online.Coding.Platform.web;

import com.example.FinalYearProject.Online.Coding.Platform.domain.Problems;
import com.example.FinalYearProject.Online.Coding.Platform.service.ProblemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class ProblemsController {
    @Autowired
    ProblemsService service;
    @GetMapping("/problems")
    public List<Problems> getAllProblems(){
       return service.findAll();
    }

}
