package com.mycompany.service;

import com.mycompany.dao.impl.UserRepositoryCustom;
import com.mycompany.entity.User;
import com.mycompany.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.List;

public class UserServiceTest {

    @Mock
    private UserRepositoryCustom userRepo;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    public void getAllTest() {
        List<User> users = userService.getAll();

        Assertions.assertEquals(1, users.size(), "1 usser");
    }

}
