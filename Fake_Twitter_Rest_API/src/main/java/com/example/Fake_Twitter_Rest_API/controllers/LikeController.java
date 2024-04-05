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
    public ResponseEntity<String> likePost(@PathVariable Long postId){
        return likeService.likePost(postId);
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<String> removeLikeFromPost(@PathVariable Long postId){
        return likeService.removeLikeFromPost(postId);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<String> getLikesNumber(@PathVariable Long postId){
        return likeService.getLikesNumber(postId);
    }


}