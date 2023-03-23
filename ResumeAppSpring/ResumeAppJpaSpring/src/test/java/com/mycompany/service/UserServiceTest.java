package com.mycompany.service;

import com.mycompany.dao.impl.UserRepositoryCustom;
import com.mycompany.entity.Country;
import com.mycompany.entity.User;
import com.mycompany.service.impl.UserServiceImpl;
import org.junit.jupiter.api.*;
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

        User user = new User(null, "test@gmail.com", "test");
        user.setName("test");
        user.setSurname("test");
        user.setNationality(new Country(1));

        List<User> users = new ArrayList<>();
        users.add(user);

        Mockito.when(userRepo.getAll()).thenReturn(users);
        Mockito.when(userRepo.filter("test", "test", 1)).thenReturn(users);
        Mockito.when(userRepo.getUserByEmail(null)).thenReturn(null);
    }

    @DisplayName("Get All Method")
    @Test
    public void getAllTest() {
        List<User> users = userService.getAll();
        Assertions.assertEquals(1, users.size(), "users size must be 1");

        Mockito.verify(userRepo, Mockito.atLeastOnce()).getAll();
        Mockito.verify(userRepo, Mockito.atLeast(1)).getAll();
    }

    @DisplayName("Filter Method")
    @Test
    public void filterTest() {
        List<User> users = userService.filter("test", "test", 1);

        Assertions.assertTrue(users.size() > 0, "users size must be over 0");
        Assertions.assertEquals(1, users.size(), "users size must be 1");
        Assertions.assertEquals("test", users.get(0).getName(), "name wrong");
        Assertions.assertEquals("test", users.get(0).getSurname(), "name wrong");
        Assertions.assertEquals(1, users.get(0).getNationality().getId(), "nationality wrong");

        Mockito.verify(userRepo, Mockito.atLeastOnce()).filter("test", "test", 1);
    }

    @DisplayName("Get By Email Method")
    @Test
    public void getByEmailTest() {
        User user = userService.getUserByEmail(null);

        Assertions.assertNull(user, "user must be null");
        Mockito.verify(userRepo, Mockito.atLeastOnce()).getUserByEmail(null);
    }

    @Disabled("not implemented yet")
    @Test
    public void test() {
    }

    @AfterAll
    static void done() {
        System.out.println("@AfterAll - executed after all test methods.");
    }

}
