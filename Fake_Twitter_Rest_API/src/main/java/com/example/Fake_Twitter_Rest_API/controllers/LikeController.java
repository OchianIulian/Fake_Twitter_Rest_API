package com.example.Fake_Twitter_Rest_API.controllers;

import com.example.Fake_Twitter_Rest_API.services.LikeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("like")
public class LikeController {
    private LikeService likeService;

    @PostMapping("/{postId}")
    public ResponseEntity<String> likePost(@PathVariable String postId){
        return ResponseEntity.ok("Like");
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<String> removeLikePost(@PathVariable String postId){
        return ResponseEntity.ok("Remove Like");
    }

    @GetMapping("/{postId}")
    public ResponseEntity<String> getLikesNumber(@PathVariable String postId){
        return ResponseEntity.ok("Like nr");
    }


}
