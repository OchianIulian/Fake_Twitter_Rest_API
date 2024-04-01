package com.example.Fake_Twitter_Rest_API.controllers;

import com.example.Fake_Twitter_Rest_API.services.FollowService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/follower")
public class FollowController {
    //private FollowService followService;

    @GetMapping("/hello")
    public ResponseEntity<String> sayHello() {
        String message = "Hello";
        return ResponseEntity.ok(message);
    }

    @GetMapping("/user-info")
    @ResponseBody
    public String getUserInfo() {
        // Obțineți autentificarea curentă
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication.getDetails());

        // Verificați dacă utilizatorul este autentificat
        if (authentication.isAuthenticated()) {
            System.out.println("E autentificat");
            // Obțineți numele de utilizator al utilizatorului autentificat
            String username = authentication.getName();

            // Returnați informații despre utilizator
            return "Utilizator conectat: " + username;
        } else {
            // Returnați un mesaj dacă utilizatorul nu este autentificat
            return "Niciun utilizator conectat";
        }
    }
}
