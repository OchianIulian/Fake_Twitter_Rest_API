package com.example.Fake_Twitter_Rest_API.controllers;

import com.example.Fake_Twitter_Rest_API.services.FollowService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//todo: De mutat follow controller in UserDetailsCOntroller si Follow service in UserActionsService
//todo: pentru a fi lasat follow controller si followService pentru entitatea follow
/**
 * This Class is a controller that contains endpoints for follow specific
 * operations that user can make after he registered
 */
@RestController
@AllArgsConstructor
public class FollowController {

    private FollowService followService;

    @GetMapping("/followers/{userEmail}")
    public ResponseEntity<String> getFollowersByEmail(@PathVariable String userEmail) {
        String message = "Hello";
        return ResponseEntity.ok(message);
    }

    @GetMapping("/following/{userEmail}")
    public ResponseEntity<String> getFollowingByEmail(@PathVariable String userEmail){
        return ResponseEntity.ok("Hello");
    }
}
