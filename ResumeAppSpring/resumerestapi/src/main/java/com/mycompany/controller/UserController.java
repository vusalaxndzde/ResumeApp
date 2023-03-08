package com.mycompany.controller;

import com.mycompany.dao.impl.UserRepositoryCustom;
import com.mycompany.dto.UserDTO;
import com.mycompany.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    private UserRepositoryCustom userRepo;

    @GetMapping("users")
    public ResponseEntity<List> getUsers() {
        List<UserDTO> userDTOS = new ArrayList<>();
        List<User> users = userRepo.getAll();
        for (User u : users) {
            userDTOS.add(new UserDTO(u));
        }
        return ResponseEntity.ok().body(userDTOS);
    }

    @Autowired
    @Qualifier("userDao1")
    public void setUserRepo(UserRepositoryCustom userRepo) {
        this.userRepo = userRepo;
    }

}
