package com.mycompany.service;

import com.mycompany.dao.impl.UserRepositoryCustom;
import com.mycompany.entity.User;
import com.mycompany.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

public class UserServiceTest {

    @Mock
    private UserRepositoryCustom userRepo;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeAll
    public static void setUp() {
        System.out.println("setup called");
    }

    @BeforeEach
    public void before() {
        System.out.println("Before called");
        MockitoAnnotations.openMocks(this);

        List<User> users = new ArrayList<>();
        User user = new User(null, "test@gmail.com", "test");

        users.add(user);

        Mockito.when(userRepo.getAll()).thenReturn(users);
    }

    @Test
    public void getAllTest() {
        List<User> users = userService.getAll();
        Assertions.assertEquals(1, users.size(), "users size must be 1");
    }

}
