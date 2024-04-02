package com.example.Fake_Twitter_Rest_API.controllers;

import com.example.Fake_Twitter_Rest_API.models.requests.AuthenticationResponse;
import com.example.Fake_Twitter_Rest_API.models.requests.LoginRequest;
import com.example.Fake_Twitter_Rest_API.models.requests.RegistrationRequest;
import com.example.Fake_Twitter_Rest_API.services.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * This Class is a controller that contains endpoints for
 * operations for registration
 */
@RestController
@RequestMapping(path = "/registration")
@AllArgsConstructor
public class RegistrationController {

    private RegistrationService registrationService;

    /**
     * SignUp
     * @param request
     * @return
     */
    @PostMapping("/register")
    public AuthenticationResponse register(@RequestBody RegistrationRequest request){
        return registrationService.register(request);
    }

    /**
     * Login
     * @param request
     * @return
     */
    @PostMapping("/login")
    public AuthenticationResponse authenticate(@RequestBody LoginRequest request){
        return registrationService.authenticate(request);
    }



}
