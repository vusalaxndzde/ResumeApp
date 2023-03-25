package com.mycompany.dao.impl;

import com.mycompany.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

//@ExtendWith(SpringExtension.class)
//@DataJpaTest --> replaced with @SpringBootTest
@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@TestPropertySource(locations = "classpath:application.properties") --> replaced with @AutoConfigureTestDatabase
public class UserRepositoryCustomITest {

    @Autowired
    @Qualifier(value = "userDao1")
    private UserRepositoryCustom userRepo;

    @DisplayName("Get All")
    @Test
    public void getAll() {
        List<User> users = userRepo.getAll();
        System.out.println(users);
        Assertions.assertEquals(4, users.size(), "users size must be 4");
    }

}
