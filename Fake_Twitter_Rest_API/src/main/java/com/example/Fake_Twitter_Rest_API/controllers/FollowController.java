package com.example.Fake_Twitter_Rest_API.controllers;

import com.example.Fake_Twitter_Rest_API.repositories.UserRepository;
import com.example.Fake_Twitter_Rest_API.services.FollowService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * This Class is a controller that contains endpoints for follow specific
 * operations that user can make after he registered
 */
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

    /**
     * Follow another user and that user will store it's follower
     * @param userEmail
     * @return
     */
    @PutMapping("/{userEmail}")
    public ResponseEntity<String> follow(@PathVariable String userEmail){
        return followService.followByEmail(userEmail);
    }

}
