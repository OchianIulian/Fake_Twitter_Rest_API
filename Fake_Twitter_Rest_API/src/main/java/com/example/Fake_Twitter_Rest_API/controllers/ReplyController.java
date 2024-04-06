package com.example.Fake_Twitter_Rest_API.controllers;

import com.example.Fake_Twitter_Rest_API.models.requests.ReplyRequest;
import com.example.Fake_Twitter_Rest_API.services.ReplyService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * This Class is a controller that contains endpoints for
 * operations for replies
 */
@RestController
@AllArgsConstructor
@RequestMapping("reply")
public class ReplyController {
    @Autowired
    private ReplyService replyService;

    /**
     * This request is used for adding a reply to a post. It can be public or private.
     * @param postId
     * @param request
     * @return
     */
    @PostMapping("/post/{postId}")
    public ResponseEntity<String> replyPost(@PathVariable Long postId, @RequestBody ReplyRequest request){
        return replyService.replyPost(postId ,request);
    }
}
