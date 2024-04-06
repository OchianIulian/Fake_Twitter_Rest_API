package com.example.Fake_Twitter_Rest_API.controllers;

import com.example.Fake_Twitter_Rest_API.models.requests.ReplyRequest;
import com.example.Fake_Twitter_Rest_API.services.ReplyService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("reply")
public class ReplyController {
    @Autowired
    private ReplyService replyService;

    @PostMapping("/post/{postId}")
    public ResponseEntity<String> replyPost(@PathVariable Long postId, @RequestBody ReplyRequest request){
        return replyService.replyPost(postId ,request);
    }
}
