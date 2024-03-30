package com.example.Fake_Twitter_Rest_API.services;

import com.example.Fake_Twitter_Rest_API.models.RegistrationRequest;
import org.springframework.stereotype.Service;

/**
 * This class is used for Register Logic
 */
@Service
public class RegistrationService {
    public String register(RegistrationRequest request) {
        return "works";
    }
}
