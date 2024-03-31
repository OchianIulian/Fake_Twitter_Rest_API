package com.example.Fake_Twitter_Rest_API.controllers;

import com.example.Fake_Twitter_Rest_API.models.LoginRequest;
import com.example.Fake_Twitter_Rest_API.models.RegistrationRequest;
import com.example.Fake_Twitter_Rest_API.models.User;
import com.example.Fake_Twitter_Rest_API.services.RegistrationService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/registration")
@AllArgsConstructor
public class RegistrationController {

    private RegistrationService registrationService;

    @PostMapping("/register")
    public String register(@RequestBody RegistrationRequest request){
        return registrationService.register(request);
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticate(@RequestBody LoginRequest request){
        System.out.println("A intrat in authenticate");
        User user =  registrationService.authenticateUser(request.getEmail(), request.getPassword());
        if(user != null){
            return ResponseEntity.ok("Autentificare reusita!");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Autentificare esuata!");
        }
    }


}
