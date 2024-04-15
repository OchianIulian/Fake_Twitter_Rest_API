package com.example.Fake_Twitter_Rest_API.controllers;

import com.example.Fake_Twitter_Rest_API.models.requests.MentionRequest;
import com.example.Fake_Twitter_Rest_API.services.MentionService;
import com.example.Fake_Twitter_Rest_API.services.PostService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MentionControllerTest {

    @Mock
    private MentionService mentionService;

    @InjectMocks
    private MentionController mentionController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void addMention() {
        MentionRequest mentionRequest = new MentionRequest(1L, "Andrei");

        //when
        when(mentionService.createMention(mentionRequest)).thenReturn(ResponseEntity.status(HttpStatus.CREATED).body("Mention created successfully"));
        ResponseEntity<String> responseEntity = mentionController.addMention(mentionRequest);

        // Then
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals("Mention created successfully", responseEntity.getBody());
        verify(mentionService, times(1)).createMention(mentionRequest);
    }


    @Test
    void getAllPostInWitchWasMentioned() {
    }
}