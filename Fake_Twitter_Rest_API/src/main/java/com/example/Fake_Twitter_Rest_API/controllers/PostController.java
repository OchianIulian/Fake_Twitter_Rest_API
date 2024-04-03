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

    @PostMapping("/create")
    public ResponseEntity<String> createPost(@RequestBody RegistrationRequest postRequest){
        //return postService.createPost(postRequest);
        return ResponseEntity.ok("Create");
    }

    @GetMapping("/get-own-posts")
    public ResponseEntity<String> getOwnPosts(){
        return postService.getOwnPosts();
    }

    @GetMapping("/get-feed")
    public ResponseEntity<String> getFeed(){
        return postService.getFeed();
    }

    @DeleteMapping("/delete-post/{id}")
    public ResponseEntity<String> deletePost(@PathVariable String id){
        return postService.deletePost(id);
    }


}
