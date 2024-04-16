package com.example.Fake_Twitter_Rest_API.services;

import com.example.Fake_Twitter_Rest_API.models.Like;
import com.example.Fake_Twitter_Rest_API.models.Post;
import com.example.Fake_Twitter_Rest_API.models.Reply;
import com.example.Fake_Twitter_Rest_API.models.User;
import com.example.Fake_Twitter_Rest_API.models.requests.ReplyRequest;
import com.example.Fake_Twitter_Rest_API.repositories.PostRepository;
import com.example.Fake_Twitter_Rest_API.repositories.ReplyRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ReplyService {
    @Autowired
    private ReplyRepository replyRepository;
    @Autowired
    private PostRepository postRepository;


    /**
     * Add a post reply. It can be public or private.
     * @param postId
     * @param replyRequest
     * @return
     */
    public ResponseEntity<String> replyPost(Long postId, ReplyRequest replyRequest) {
        Optional<Post> post = postRepository.findById(postId);

        if(post.isPresent()){
            Reply reply = new Reply(post.get(), replyRequest.getMessage(), replyRequest.getIs_public());
            replyRepository.save(reply);
        }

        return ResponseEntity.ok("Reply successful!");
    }

    /**
     * Delete all replies from a post
     * @param postId
     */
    public void deleteAllRepliesFromPostWithId(Long postId){
        Optional<Post> post = postRepository.findById(postId);
        if(post.isPresent()){
            List<Reply> replyList = replyRepository.findByPost(post.get());
            for(Reply reply: replyList) {
                replyRepository.delete(reply);
            }
        } else {
            throw new RuntimeException("Post not found");
        }

    }
}
