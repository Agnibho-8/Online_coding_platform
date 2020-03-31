package com.example.FinalYearProject.Online.Coding.Platform.web;

import com.example.FinalYearProject.Online.Coding.Platform.domain.Attempts;
import com.example.FinalYearProject.Online.Coding.Platform.service.AttemptsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
@RestController
public class AttemptsController {
    @Autowired
    AttemptsService service;
    @GetMapping("/users/{username}/attempts")
    public Attempts findByUsername(@PathParam("username")String username){
       return service.findByUsername(username);
    }

}
