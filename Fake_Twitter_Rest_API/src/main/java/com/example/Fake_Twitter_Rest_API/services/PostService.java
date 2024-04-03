package com.example.Fake_Twitter_Rest_API.services;

import com.example.Fake_Twitter_Rest_API.models.Post;
import com.example.Fake_Twitter_Rest_API.models.User;
import com.example.Fake_Twitter_Rest_API.models.requests.PostRequest;
import com.example.Fake_Twitter_Rest_API.repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PostService {
    @Autowired
    PostRepository postRepository;

    /**
     * Create a new post
     * @param postRequest
     * @return
     */
    public ResponseEntity<String> createPost(PostRequest postRequest) {
        Post post = new Post(postRequest.getMessage());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object pricipal = authentication.getPrincipal();

        User user = (User) pricipal;
        post.setUser(user);

        postRepository.save(post);
        return ResponseEntity.ok("Create post");
    }

    public ResponseEntity<String> getOwnPosts() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object pricipal = authentication.getPrincipal();
        User user = (User) pricipal;

        Long id = user.getId();

        List<Post> posts = postRepository.findPostsByUserId(id);
        return ResponseEntity.ok(posts.toString());
    }

    public ResponseEntity<String> getFeed() {
        return ResponseEntity.ok("Get Feed");
    }

    public ResponseEntity<String> deletePost(String id) {
        return ResponseEntity.ok("Delete Post");
    }
}
