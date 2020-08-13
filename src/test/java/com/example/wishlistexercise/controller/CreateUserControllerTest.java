package com.example.wishlistexercise.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
class CreateUserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void createUserStatusTest() throws Exception {

        String userName = "UserName";

        RequestBuilder request = MockMvcRequestBuilders
                .post("/create-user")
                .param("name", userName)
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void userStoredInPersistenceTest(){
        User user = new User("FirstUser");
        userRepository.save(user);
        List<User> allUsers = userRepository.findAll();
        assertEquals(user.getName(), allUsers.get(0).getName());

    }

}