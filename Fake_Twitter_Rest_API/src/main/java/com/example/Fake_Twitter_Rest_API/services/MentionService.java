package com.example.Fake_Twitter_Rest_API.services;

import com.example.Fake_Twitter_Rest_API.models.Mention;
import com.example.Fake_Twitter_Rest_API.models.Post;
import com.example.Fake_Twitter_Rest_API.models.Reply;
import com.example.Fake_Twitter_Rest_API.models.User;
import com.example.Fake_Twitter_Rest_API.models.requests.MentionRequest;
import com.example.Fake_Twitter_Rest_API.models.requests.PostRequest;
import com.example.Fake_Twitter_Rest_API.repositories.MentionRepository;
import com.example.Fake_Twitter_Rest_API.repositories.PostRepository;
import com.example.Fake_Twitter_Rest_API.repositories.UserRepository;
import com.example.Fake_Twitter_Rest_API.utils.Utils;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * This class is responsible for Mention logic
 */
@Service
@AllArgsConstructor
public class MentionService {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MentionRepository mentionRepository;

    /**
     * This method creates a new mention
     * @param mentionRequest
     * @return
     */
    public ResponseEntity<String> createMention(MentionRequest mentionRequest) {
        Optional<Post> post = postRepository.findById(mentionRequest.getPostId());
        if(post.isEmpty()) return ResponseEntity.ok("no post found");
        Optional<User> user = userRepository.findByEmail(mentionRequest.getUsername());
        if(user.isEmpty()) return ResponseEntity.ok("this user was not found");
        Mention mention = new Mention(user.get(), post.get());
        mentionRepository.save(mention);
        return ResponseEntity.ok("Mention created");
    }

    /**
     * This method gets all Posts that mention somebody
     * @return
     */
    public ResponseEntity<String> getPersonalMentions() {
        User authenticatedUser = Utils.getAuthenticatedUser();
        List<Post> postList = mentionRepository.findPostsByMentionedUserId(authenticatedUser.getId());
        return ResponseEntity.ok(postList.toString());
    }

    /**
     * This method delete all mentions from a post by post's id
     * @param postId
     */
    public void deleteAllMentionsFromPostWithId(Long postId){
        Optional<Post> post = postRepository.findById(postId);
        if(post.isPresent()){
            List<Mention> mentionList = mentionRepository.findByPost(post.get());
            for(Mention mention: mentionList) {
                mentionRepository.delete(mention);
            }
        } else {
            throw new RuntimeException("Post not found");
        }
    }
}
