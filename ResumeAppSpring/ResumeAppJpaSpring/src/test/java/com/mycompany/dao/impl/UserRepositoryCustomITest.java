package com.mycompany.dao.impl;

import com.mycompany.ResumeAppJpaSpringApplication;
import com.mycompany.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

//@ExtendWith(SpringExtension.class)
//@DataJpaTest --> replaced with @SpringBootTest
@SpringBootTest(classes = ResumeAppJpaSpringApplication.class)
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) --> replaced with (classes = ResumeAppJpaSpringApplication.class)
//@TestPropertySource(locations = "classpath:application.properties") --> replaced with @AutoConfigureTestDatabase
public class UserRepositoryCustomITest {

    @Autowired
    @Qualifier(value = "userDao1")
    private UserRepositoryCustom userRepo;

    @DisplayName("Get All")
    @Test
    public void getAllTest() {
        List<User> users = userRepo.getAll();
        System.out.println(users);
        Assertions.assertEquals(4, users.size(), "users size must be 4");
    }

    @DisplayName("Filter")
    @Test
    public void filterTest() {
        List<User> users = userRepo.filter("test3", "test3", null);
        System.out.println(users);
        Assertions.assertTrue(users.size() > 0);
    }

}
