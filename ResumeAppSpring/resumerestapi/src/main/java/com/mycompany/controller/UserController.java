package com.mycompany.controller;

import com.mycompany.dao.impl.UserRepositoryCustom;
import com.mycompany.dto.ResponseDTO;
import com.mycompany.dto.UserDTO;
import com.mycompany.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class UserController {

    private UserRepositoryCustom userRepo;

    @GetMapping("users")
    public ResponseEntity<ResponseDTO> getUsers() {
        List<UserDTO> userDTOS = new ArrayList<>();
        List<User> users = userRepo.getAll();
        for (User u : users) {
            userDTOS.add(new UserDTO(u));
        }
        if (users != null) {
            throw new IllegalArgumentException("exception in user controller");
        }
        return ResponseEntity.ok().body(ResponseDTO.of(userDTOS));
    }

    @GetMapping("users/filter")
    public ResponseEntity<ResponseDTO> filter(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "surname", required = false) String surname
    ) {
        List<UserDTO> userDTOS = new ArrayList<>();
        List<User> users = userRepo.filter(name, surname, null);
        for (User u : users) {
            userDTOS.add(new UserDTO(u));
        }
        return ResponseEntity.ok().body(ResponseDTO.of(userDTOS));
    }

    @GetMapping("users/{id}")
    public ResponseEntity<ResponseDTO> getUser(@PathVariable("id") Integer id) {
        User user = userRepo.getById(id);
        UserDTO userDTO = new UserDTO(user);
        return ResponseEntity.ok(ResponseDTO.of(userDTO));
    }

    @DeleteMapping("users/{id}")
    public ResponseEntity<ResponseDTO> deleteUser(@PathVariable("id") Integer id) {
        User user = userRepo.getById(id);
        userRepo.removeUser(id);
        return ResponseEntity.ok(ResponseDTO.of(new UserDTO(user), "Successfully deleted"));
    }

    @PostMapping("users")
    public ResponseEntity<ResponseDTO> addUser(@RequestBody UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setSurname(userDTO.getSurname());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());

        userRepo.addUser(user);
        userDTO.setId(user.getId());
        return ResponseEntity.ok(ResponseDTO.of(userDTO, "Successfully added"));
    }

    @PutMapping("users/{id}")
    public ResponseEntity<ResponseDTO> updateUser(@PathVariable("id") Integer id,
                                                  @RequestBody UserDTO userDTO) {
        User user = new User();
        user.setId(id);
        user.setName(userDTO.getName());
        user.setSurname(userDTO.getSurname());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());

        userRepo.updateUser(user);
        userDTO.setId(user.getId());
        return ResponseEntity.ok(ResponseDTO.of(userDTO, "Successfully updated"));
    }

    @Autowired
    @Qualifier("userDao1")
    public void setUserRepo(UserRepositoryCustom userRepo) {
        this.userRepo = userRepo;
    }

}
