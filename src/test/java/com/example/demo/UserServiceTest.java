package com.example.demo;

/**
 * 功能描述
 *
 * @author KEVIN
 * @since 2021-12-06
 */
import com.example.demo.service.CreditService;
import com.example.demo.service.UserService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;

@SpringBootTest
class UserServiceTest {
    @Autowired
    UserService userService;

    @MockBean
    CreditService creditService;

    @Test
    void testGet() {
        Long userId = 22L;
        int expectCredit = 42;

        given(this.creditService.getUserCredit(anyLong())).willReturn(expectCredit);
        int result = userService.getUserCredit(userId);
        assertEquals(expectCredit, result);
        System.out.println("Passed.");
    }
}
