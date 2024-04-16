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
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class PostService {
    @Autowired
    PostRepository postRepository;

    @Autowired
    LikeService likeService;

    @Autowired
    ReplyService replyService;

    @Autowired
    MentionService mentionService;

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

    /**
     * Return a String with all posts of connected user
     * @return
     */
    public ResponseEntity<String> getOwnPosts() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object pricipal = authentication.getPrincipal();
        User user = (User) pricipal;

        Long id = user.getId();

        List<Post> posts = postRepository.findPostsByUserId(id);
        return ResponseEntity.ok(posts.toString());
    }

    /**
     * Return as string with all posts of connected user's friends
     * @return
     */
    public ResponseEntity<String> getFeed() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object pricipal = authentication.getPrincipal();
        User user = (User) pricipal;

        Long id = user.getId();

        List<Post> posts = postRepository.getFeed(id);
        return ResponseEntity.ok(posts.toString());
    }

    /**
     * Delete a post from it's table
     * @param postId
     * @return
     */
    public ResponseEntity<String> deletePost(Long postId) {
        Optional<Post> post = postRepository.findById(postId);
        //delete the likes
        likeService.removeAllLikesFromPost(postId);
        //delete all replies
        replyService.deleteAllRepliesFromPostWithId(postId);
        //delete metions
        mentionService.deleteAllMentionsFromPostWithId(postId);

        //delete the post
        post.ifPresent(value -> postRepository.delete(value));

        return ResponseEntity.ok("Delete Post");
    }
}
