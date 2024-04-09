package com.example.Fake_Twitter_Rest_API.controllers;

import com.example.Fake_Twitter_Rest_API.models.requests.RegistrationRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class RegistrationControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @ParameterizedTest
    @MethodSource("com.example.Fake_Twitter_Rest_API.data_providers.registration.RegistrationDataProvider#provideStringsForTest")
    public void register(String firstname, String lastName, String email, String password) throws Exception {

        RegistrationRequest request1 = new RegistrationRequest(
                firstname,
                lastName,
                email,
                password);


        String jsonRequest = objectMapper.writeValueAsString(request1);
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/registration/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest))
                        .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void authenticate() {
    }
}