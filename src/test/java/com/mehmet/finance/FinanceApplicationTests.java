package com.mehmet.finance;

import com.mehmet.finance.entities.User;
import com.mehmet.finance.services.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertNotNull;
@SpringBootTest(classes = FinanceApplication.class)
@RequiredArgsConstructor
class FinanceApplicationTests {
    private final UserService userService;
    @Test
    public void testGetUserById() {
        User user = userService.getUserById(1L);
        assertNotNull(user);
    }




}
