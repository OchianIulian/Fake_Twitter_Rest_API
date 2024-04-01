package com.example.Fake_Twitter_Rest_API.controllers;

import com.example.Fake_Twitter_Rest_API.models.requests.AuthenticationResponse;
import com.example.Fake_Twitter_Rest_API.models.requests.LoginRequest;
import com.example.Fake_Twitter_Rest_API.models.requests.RegistrationRequest;
import com.example.Fake_Twitter_Rest_API.models.User;
import com.example.Fake_Twitter_Rest_API.security.config.WebSecurityConfig;
import com.example.Fake_Twitter_Rest_API.services.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/registration")
@AllArgsConstructor
public class RegistrationController {

    private RegistrationService registrationService;
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public AuthenticationResponse register(@RequestBody RegistrationRequest request){
        return registrationService.register(request);
    }

    @PostMapping("/login")
    public AuthenticationResponse authenticate(@RequestBody LoginRequest request){
        return registrationService.authenticate(request);

    }


}
