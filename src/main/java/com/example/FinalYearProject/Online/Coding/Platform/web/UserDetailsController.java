package com.example.FinalYearProject.Online.Coding.Platform.web;

import com.example.FinalYearProject.Online.Coding.Platform.domain.UserDetails;
import com.example.FinalYearProject.Online.Coding.Platform.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.Optional;
@RestController
public class UserDetailsController{
    @Autowired
    UserDetailsService service;
    @GetMapping("/users/{username}/performance")
    public Optional<UserDetails> findByUsername(@PathParam("username") String username){
        return service.findByUsername(username);
    }
}
