package com.example.FinalYearProject.Online.Coding.Platform.web;

import com.example.FinalYearProject.Online.Coding.Platform.ModelResponse.UserLoginRequest;
import com.example.FinalYearProject.Online.Coding.Platform.domain.User;
import com.example.FinalYearProject.Online.Coding.Platform.service.UserDetailsService;
import com.example.FinalYearProject.Online.Coding.Platform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.Optional;

@RestController
public class UserController  {
   @Autowired
    UserService service;
   @Autowired
   UserDetailsService userDetailsService;
   @Autowired
   UserOperations userOperations;
   @CrossOrigin
    @PostMapping("/signup")
    public ResponseEntity<User> addUser(@RequestBody User toBeAdded){
        System.out.println("Sign Up Initiated!!!");
        String username = service.addNewUser(toBeAdded);
        userDetailsService.addNewUser(username,toBeAdded);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create("/users/username"));
        userOperations.addUserProblemID(username);
        System.out.println("Sign Up Done!!!");
        return new ResponseEntity<User>(toBeAdded,headers, HttpStatus.CREATED);
    }
    @CrossOrigin
    @PostMapping("/login")
    public  ResponseEntity<String> UserLogin(@RequestBody UserLoginRequest userLoginRequest){
        System.out.println("Log In Initiated!!!");
        System.out.println(userLoginRequest.getUsername());
       String password =  service.findPasswords(userLoginRequest.getUsername());
        System.out.println(password);
       String username=userLoginRequest.getUsername();
        if(userLoginRequest.getPassword().equals(password)){
       HttpHeaders headers = new HttpHeaders();
       headers.setLocation(URI.create("/users/"+username));
       userOperations.setCurrentUsername(username);
        System.out.println("Log In Done!!");
       return new ResponseEntity<String>("yes",headers,HttpStatus.OK);}
        else
            return new ResponseEntity<String>("no",HttpStatus.OK);
}
}
