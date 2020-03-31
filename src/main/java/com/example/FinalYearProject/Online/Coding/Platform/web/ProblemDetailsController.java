package com.example.FinalYearProject.Online.Coding.Platform.web;

import com.example.FinalYearProject.Online.Coding.Platform.domain.ProblemDetails;
import com.example.FinalYearProject.Online.Coding.Platform.domain.ProblemTestCaseId;
import com.example.FinalYearProject.Online.Coding.Platform.service.ProblemDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
@RestController
public class ProblemDetailsController {
    @Autowired
    ProblemDetailsService service;

    @GetMapping("problems/{id}")
    public Optional<ProblemDetails> findById(@PathVariable("id") ProblemTestCaseId id){
        return service.findById(id);
    }
}
