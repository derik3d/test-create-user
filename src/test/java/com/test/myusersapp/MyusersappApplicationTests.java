package com.test.myusersapp;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.myusersapp.dto.user_creation_request.CreateUserRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureWebClient;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
class MyusersappApplicationTests {

    @Autowired
    private MockMvc mvc;


    @Test
    void contextLoads() throws Exception {

    }

    @Test
    void testPostUserEndpointOk() throws Exception {

        CreateUserRequest createUserRequest = new CreateUserRequest("Dani", "Dani@el.com", "1234567i", new ArrayList<>());

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(createUserRequest);

        ResultActions perform0 = mvc.perform(post("/api/v1/user").contentType(
                MediaType.APPLICATION_JSON).content(json)).andExpect(status().is2xxSuccessful());

    }


    @Test
    void testPostUserEndpointAlreadyUsedEmail() throws Exception {

        CreateUserRequest createUserRequest = new CreateUserRequest("DaniDaza", "DaniDaza@el.com", "1234567i", new ArrayList<>());

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(createUserRequest);

        ResultActions perform0 = mvc.perform(post("/api/v1/user").contentType(
                MediaType.APPLICATION_JSON).content(json)).andExpect(status().is2xxSuccessful());

        ResultActions perform1 = mvc.perform(post("/api/v1/user").contentType(
                MediaType.APPLICATION_JSON).content(json)).andExpect(status().is4xxClientError());

    }

    @Test
    void testPostUserEndpointMissingFields() throws Exception {


        ObjectMapper objectMapper = new ObjectMapper();

        CreateUserRequest createUserRequest = new CreateUserRequest("", "Dani@el.com", "1234567i", new ArrayList<>());
        String json = objectMapper.writeValueAsString(createUserRequest);
        ResultActions perform0 = mvc.perform(post("/api/v1/user").contentType(
                MediaType.APPLICATION_JSON).content(json)).andExpect(status().is4xxClientError());


        CreateUserRequest createUserRequest1 = new CreateUserRequest("DaniDaza", "", "1234567i", new ArrayList<>());
        json = objectMapper.writeValueAsString(createUserRequest1);
        ResultActions perform1 = mvc.perform(post("/api/v1/user").contentType(
                MediaType.APPLICATION_JSON).content(json)).andExpect(status().is4xxClientError());

        CreateUserRequest createUserRequest2 = new CreateUserRequest("DaniDaza", "Dani@el.com", "", new ArrayList<>());
        json = objectMapper.writeValueAsString(createUserRequest2);
        ResultActions perform2 = mvc.perform(post("/api/v1/user").contentType(
                MediaType.APPLICATION_JSON).content(json)).andExpect(status().is4xxClientError());

        CreateUserRequest createUserRequest3 = new CreateUserRequest("DaniDaza", "Dani@el.com", "1234567i", null);
        json = objectMapper.writeValueAsString(createUserRequest3);
        ResultActions perform3 = mvc.perform(post("/api/v1/user").contentType(
                MediaType.APPLICATION_JSON).content(json)).andExpect(status().is4xxClientError());

    }

    @Test
    void testPostUserEndpointNoBodyExpects4xx() throws Exception {

        ResultActions perform0 = mvc.perform(post("/api/v1/user").contentType(
                MediaType.APPLICATION_JSON)).andExpect(status().is4xxClientError());
    }

    @Test
    void testTestGetEndpointWelcomeOk() throws Exception {

        ResultActions perform0 = mvc.perform(get("/api/v1/welcome").contentType(
                MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }


}