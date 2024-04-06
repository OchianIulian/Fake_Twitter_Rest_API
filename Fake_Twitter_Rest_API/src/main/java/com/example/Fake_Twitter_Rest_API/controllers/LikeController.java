package com.example.Fake_Twitter_Rest_API.controllers;

import com.example.Fake_Twitter_Rest_API.services.LikeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * This class contains the endpoints for Like requests
 */
@RestController
@AllArgsConstructor
@RequestMapping("like")
public class LikeController {
    private LikeService likeService;

    /**
     * Like a post
     * @param postId
     * @return
     */
    @PostMapping("/{postId}")
    public ResponseEntity<String> likePost(@PathVariable Long postId){
        return likeService.likePost(postId);
    }

    /**
     * Unlike a post
     * @param postId
     * @return
     */
    @DeleteMapping("/{postId}")
    public ResponseEntity<String> removeLikeFromPost(@PathVariable Long postId){
        return likeService.removeLikeFromPost(postId);
    }

    /**
     * Gets the number of likes from a post found by it's Id
     * @param postId
     * @return
     */
    @GetMapping("/{postId}")
    public ResponseEntity<String> getLikesNumber(@PathVariable Long postId){
        return likeService.getLikesNumber(postId);
    }


}
