package com.example.Fake_Twitter_Rest_API.services;

import com.example.Fake_Twitter_Rest_API.models.requests.PostRequest;
import com.example.Fake_Twitter_Rest_API.repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class PostService {
    @Autowired
    PostRepository postRepository;

    public ResponseEntity<String> createPost(PostRequest postRequest) {
        return ResponseEntity.ok("Create post");
    }

    public ResponseEntity<String> getOwnPosts() {
        return ResponseEntity.ok("Get Own Posts");
    }

    public ResponseEntity<String> getFeed() {
        return ResponseEntity.ok("Get Feed");
    }

    public ResponseEntity<String> deletePost(String id) {
        return ResponseEntity.ok("Delete Post");
    }
}
