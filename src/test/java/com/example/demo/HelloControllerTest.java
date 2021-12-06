package com.example.demo;

import com.example.demo.controller.HelloWorldController;
import com.example.demo.service.UserService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

/**
 * 功能描述
 *
 * @author KEVIN
 * @since 2021-12-06
 */
@WebMvcTest(HelloWorldController.class)
class HelloControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    UserService userService;

    @Test
    public void testMvc() throws Exception {
        String expectString = "Hello Spring boot!";
        mvc.perform(get("/")).andExpect(content().string(expectString));
        System.out.println("Controller Passed.");
    }
}
