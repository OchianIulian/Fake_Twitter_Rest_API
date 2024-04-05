package com.example.Fake_Twitter_Rest_API.services;

import com.example.Fake_Twitter_Rest_API.models.Like;
import com.example.Fake_Twitter_Rest_API.models.Post;
import com.example.Fake_Twitter_Rest_API.models.User;
import com.example.Fake_Twitter_Rest_API.repositories.LikeRepository;
import com.example.Fake_Twitter_Rest_API.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class LikeService {
    @Autowired
    private LikeRepository likeRepository;

    @Autowired
    private PostRepository postRepository;


    public ResponseEntity<String> likePost(Long postId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object pricipal = authentication.getPrincipal();
        User user = (User) pricipal;

        Optional<Post> post = postRepository.findById(postId);
        if(post.isPresent()){
            Like like = new Like(user, post.get());
            likeRepository.save(like);
        } else {
            throw new RuntimeException("Post not found");
        }

        return ResponseEntity.ok("Liked post");
    }

    public ResponseEntity<String> removeLikeFromPost(Long postId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object pricipal = authentication.getPrincipal();
        User user = (User) pricipal;

        Optional<Post> post = postRepository.findById(postId);
        if(post.isPresent()){
            Optional<Like> like = likeRepository.findByPost(postId);
            like.ifPresent(value -> likeRepository.delete(value));
        } else {
            throw new RuntimeException("Post not found");
        }

        return ResponseEntity.ok("Remove Like");
    }

    public ResponseEntity<String> getLikesNumber(Long postId) {
        Long likeNr = likeRepository.getPostLikes(postId);

        return ResponseEntity.ok("This post has " + likeNr + " likes");
    }
}
