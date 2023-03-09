package com.mycompany.controller;

import com.mycompany.dao.impl.UserRepositoryCustom;
import com.mycompany.dto.UserDTO;
import com.mycompany.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    private UserRepositoryCustom userRepo;

    @GetMapping("users")
    public ResponseEntity<List<UserDTO>> getUsers() {
        List<UserDTO> userDTOS = new ArrayList<>();
        List<User> users = userRepo.getAll();
        for (User u : users) {
            userDTOS.add(new UserDTO(u));
        }
        return ResponseEntity.ok().body(userDTOS);
    }

    @GetMapping("users/filter")
    public ResponseEntity<List<UserDTO>> filter(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "surname", required = false) String surname
    ) {
        List<UserDTO> userDTOS = new ArrayList<>();
        List<User> users = userRepo.filter(name, surname, null);
        for (User u : users) {
            userDTOS.add(new UserDTO(u));
        }
        return ResponseEntity.ok().body(userDTOS);
    }

    @GetMapping("users/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable("id") Integer id) {
        User user = userRepo.getById(id);
        UserDTO userDTO = new UserDTO(user);
        return ResponseEntity.ok(userDTO);
    }

    @Autowired
    @Qualifier("userDao1")
    public void setUserRepo(UserRepositoryCustom userRepo) {
        this.userRepo = userRepo;
    }

}
