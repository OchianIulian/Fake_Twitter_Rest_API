package com.example.Fake_Twitter_Rest_API.controllers;

import com.example.Fake_Twitter_Rest_API.models.requests.PostRequest;
import com.example.Fake_Twitter_Rest_API.models.requests.RegistrationRequest;
import com.example.Fake_Twitter_Rest_API.services.PostService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("post")
public class PostController {
    @Autowired
    private PostService postService;

    /**
     * Create a new post
     * @param postRequest
     * @return
     */
    @PostMapping("/create")
    public ResponseEntity<String> createPost(@RequestBody PostRequest postRequest){
        return postService.createPost(postRequest);
    }

    /**
     * Return a String with all posts of connected user
     * @return
     */
    @GetMapping("/get-own-posts")
    public ResponseEntity<String> getOwnPosts(){
        return postService.getOwnPosts();
    }

    /**
     * Return as string with all posts of connected user's friends
     * @return
     */
    @GetMapping("/get-feed")
    public ResponseEntity<String> getFeed(){
        return postService.getFeed();
    }

    /**
     * Delete a post by it's ID
     * @param id
     * @return
     */
    @DeleteMapping("/delete-post/{id}")
    public ResponseEntity<String> deletePost(@PathVariable Long id){
        return postService.deletePost(id);
    }


}
