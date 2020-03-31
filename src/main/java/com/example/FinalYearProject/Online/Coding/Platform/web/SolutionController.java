package com.example.FinalYearProject.Online.Coding.Platform.web;

import com.example.FinalYearProject.Online.Coding.Platform.domain.Solution;
import com.example.FinalYearProject.Online.Coding.Platform.service.SolutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.Optional;
@RestController
public class SolutionController {
    @Autowired
    SolutionService service;
    @GetMapping("problems/{id}/solution")
    public Optional<Solution> findByProblemId(@PathParam("id")int problemId){
        return service.findByProblemId(problemId);
    }
}
