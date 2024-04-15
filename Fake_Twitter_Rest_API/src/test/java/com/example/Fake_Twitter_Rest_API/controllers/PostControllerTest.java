package com.example.Fake_Twitter_Rest_API.controllers;

import com.example.Fake_Twitter_Rest_API.models.requests.PostRequest;
import com.example.Fake_Twitter_Rest_API.services.PostService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-test.properties")
class PostControllerTest {

    @Mock
    private PostService postService;

    @InjectMocks
    private PostController postController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @ParameterizedTest
    @MethodSource("com.example.Fake_Twitter_Rest_API.data_providers.registration.RegistrationDataProvider#provideStringsForTest")
    void createPost(String content) {
        PostRequest postRequest = new PostRequest(content);

        // When
        when(postService.createPost(postRequest)).thenReturn(ResponseEntity.status(HttpStatus.CREATED).body("Post created successfully"));
        ResponseEntity<String> responseEntity = postController.createPost(postRequest);

        // Then
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals("Post created successfully", responseEntity.getBody());
        verify(postService, times(1)).createPost(postRequest);
    }

    @Test
    void getOwnPosts() {
    }

    @Test
    void getFeed() {
    }

    @Test
    void deletePost() {
    }
}