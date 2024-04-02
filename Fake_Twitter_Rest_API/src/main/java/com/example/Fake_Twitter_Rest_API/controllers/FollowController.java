package com.example.Fake_Twitter_Rest_API.controllers;

import com.example.Fake_Twitter_Rest_API.repositories.UserRepository;
import com.example.Fake_Twitter_Rest_API.services.FollowService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/follow")
public class FollowController {

    private FollowService followService;


    @GetMapping("/hello")
    public ResponseEntity<String> sayHello() {
        String message = "Hello";
        return ResponseEntity.ok(message);
    }

    @PutMapping("/{userEmail}")
    public ResponseEntity<String> follow(@PathVariable String userEmail){
        return followService.followByEmail(userEmail);
    }

}
