package com.example.Fake_Twitter_Rest_API.controllers;

import com.example.Fake_Twitter_Rest_API.models.requests.PostRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-test.properties")
class PostControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private RegistrationControllerTest registrationControllerTest;



    @ParameterizedTest
    @MethodSource("com.example.Fake_Twitter_Rest_API.data_providers.registration.RegistrationDataProvider#provideStringsForTest")
    void createPost(String content) {
        //PostRequest postRequest = new PostRequest();

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