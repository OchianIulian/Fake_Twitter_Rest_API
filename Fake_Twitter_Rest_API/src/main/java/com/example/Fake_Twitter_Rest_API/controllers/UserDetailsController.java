package com.example.Fake_Twitter_Rest_API.controllers;

import com.example.Fake_Twitter_Rest_API.services.RegistrationService;
import com.example.Fake_Twitter_Rest_API.services.UserActionsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * This Class is a controller that contains endpoints for
 * operations that user can make after he registered
 */
@RestController
@RequestMapping(path = "/user")
@AllArgsConstructor
public class UserDetailsController {

    private RegistrationService registrationService;
    private UserActionsService userActionsService;


    /**
     * Get personal information
     * @return
     */
    @GetMapping("/user-info")
    public String getUserInfo(){
        return userActionsService.getUserInfo();
    }

    /**
     * Get another user information by email
     * @param username
     * @return
     */
    @GetMapping("/user-info/{username}")
    public String getUserDetailsByUsername(@PathVariable String username){
        return userActionsService.getUserDetailsByUsername(username);
    }

    /**
     * Delete personal account
     * @param username
     * @return
     */
    @DeleteMapping("/del-personal-acc")
    public String deleteAccount(String username){
        return registrationService.deletePersonalAccount();
    }

    /**
     * Follow another user and that user will store it's follower
     * @param userEmail
     * @return
     */
    @PutMapping("follow/{userEmail}")
    public ResponseEntity<String> follow(@PathVariable String userEmail){
        return userActionsService.followByEmail(userEmail);
    }

    @DeleteMapping("unfollow/{userEmail}")
    public ResponseEntity<String> unfollow(@PathVariable String userEmail){
        return userActionsService.unfollowByEmail(userEmail);
    }
}
