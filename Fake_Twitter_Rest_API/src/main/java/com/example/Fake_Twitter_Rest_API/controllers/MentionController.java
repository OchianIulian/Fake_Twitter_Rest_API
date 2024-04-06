package com.example.Fake_Twitter_Rest_API.controllers;

import com.example.Fake_Twitter_Rest_API.models.requests.MentionRequest;
import com.example.Fake_Twitter_Rest_API.models.requests.PostRequest;
import com.example.Fake_Twitter_Rest_API.repositories.MentionRepository;
import com.example.Fake_Twitter_Rest_API.services.MentionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("mention")
public class MentionController {
    @Autowired
    private MentionRepository mentionRepository;

    @Autowired
    private MentionService mentionService;
    /**
     * Create a new post
     * @param mentionRequest
     * @return
     */
    @PostMapping("/person")
    public ResponseEntity<String> addMention(@RequestBody MentionRequest mentionRequest){
        return mentionService.createMention(mentionRequest);
    }

    @GetMapping("/get-personal-mentions")
    public ResponseEntity<String> getAllPostInWitchWasMentioned(){
        return mentionService.getPersonalMentions();
    }



}
