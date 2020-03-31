package com.example.FinalYearProject.Online.Coding.Platform.web;

import com.example.FinalYearProject.Online.Coding.Platform.domain.User;
import com.example.FinalYearProject.Online.Coding.Platform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
@RestController
public class UserController  {
   @Autowired
    UserService service;
    @PostMapping("/users")
    public ResponseEntity<User> addUser(@RequestBody User toBeAdded){
        String username = service.addNewUser(toBeAdded);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create("/users/username"));
        return new ResponseEntity<User>(toBeAdded,headers, HttpStatus.CREATED);
    }
}
