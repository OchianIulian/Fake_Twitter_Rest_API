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
import java.util.List;
import java.util.Optional;

@Service
public class LikeService {
    @Autowired
    private LikeRepository likeRepository;

    @Autowired
    private PostRepository postRepository;


    /**
     * Like a post by it's id and save this action into it's table
     * @param postId
     * @return
     */
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

    /**
     * Unlike a post by it's id and save this action into it's table
     * @param postId
     * @return
     */
    public ResponseEntity<String> removeLikeFromPost(Long postId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object pricipal = authentication.getPrincipal();
        User user = (User) pricipal;

        Optional<Post> post = postRepository.findById(postId);

        if(post.isPresent()){
            Optional<Like> like = likeRepository.findByPostAndUser(post.get(), user);
            if (like.isPresent()){
                likeRepository.delete(like.get());
            }
        } else {
            throw new RuntimeException("Post not found");
        }

        return ResponseEntity.ok("Remove Like");
    }

    /**
     * Return the number of likes
     * @param postId
     * @return
     */
    public ResponseEntity<String> getLikesNumber(Long postId) {
        Long likeNr = likeRepository.getPostLikes(postId);

        return ResponseEntity.ok("This post has " + likeNr + " likes");
    }

    /**
     * Remove all likes from a post
     * @param postId
     */
    public void removeAllLikesFromPost(Long postId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object pricipal = authentication.getPrincipal();
        User user = (User) pricipal;

        Optional<Post> post = postRepository.findById(postId);
        if(post.isPresent()){
            List<Like> likeList = likeRepository.findByPost(post.get());
            for(Like like: likeList) {
                likeRepository.delete(like);
            }
        } else {
            throw new RuntimeException("Post not found");
        }
    }
}
