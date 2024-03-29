package com.mycompany.controller;

import com.mycompany.dao.impl.UserRepositoryCustom;
import com.mycompany.dto.ResponseDTO;
import com.mycompany.dto.SkillDTO;
import com.mycompany.dto.UserDTO;
import com.mycompany.dto.UserSkillDTO;
import com.mycompany.entity.Skill;
import com.mycompany.entity.User;
import com.mycompany.entity.UserSkill;
import org.modelmapper.ModelMapper;
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
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("users")
    public ResponseEntity<ResponseDTO> getUsers() {
        List<UserDTO> userDTOS = new ArrayList<>();
        List<User> users = userRepo.getAll();
        for (User u : users) {
//            userDTOS.add(new UserDTO(u));
            userDTOS.add(convertToUserDto(u));
        }
//        if (users != null) {
//            throw new IllegalArgumentException("exception in user controller");
//        }
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
            userDTOS.add(convertToUserDto(u));
        }
        return ResponseEntity.ok().body(ResponseDTO.of(userDTOS));
    }

    @GetMapping("users/{id}")
    public ResponseEntity<ResponseDTO> getUser(@PathVariable("id") Integer id) {
        User user = userRepo.getById(id);
        UserDTO userDTO = convertToUserDto(user);
        return ResponseEntity.ok(ResponseDTO.of(userDTO));
    }

    @DeleteMapping("users/{id}")
    public ResponseEntity<ResponseDTO> deleteUser(@PathVariable("id") Integer id) {
        User user = userRepo.getById(id);
        userRepo.removeUser(id);
        return ResponseEntity.ok(ResponseDTO.of(convertToUserDto(user), "Successfully deleted"));
    }

    @PostMapping("users")
    public ResponseEntity<ResponseDTO> addUser(@RequestBody UserDTO userDTO) {
        User user = convertToEntity(userDTO);
        userRepo.addUser(user);
        userDTO.setId(user.getId());
        return ResponseEntity.ok(ResponseDTO.of(userDTO, "Successfully added"));
    }

    @PutMapping("users/{id}")
    public ResponseEntity<ResponseDTO> updateUser(@PathVariable("id") Integer id,
                                                  @RequestBody UserDTO userDTO) {
        User user = convertToEntity(userDTO);
        user.setId(id);

        userRepo.updateUser(user);
        userDTO.setId(user.getId());
        return ResponseEntity.ok(ResponseDTO.of(userDTO, "Successfully updated"));
    }

    // Mappings
    private UserDTO convertToUserDto(User user) {
        UserDTO userDTO = modelMapper.map(user, UserDTO.class);
        List<UserSkillDTO> userSkillDTOList = new ArrayList<>();
        for (UserSkill userSkill : user.getUserSkillList()) {
            userSkillDTOList.add(convertToUserSkillDto(userSkill));
        }
        userDTO.setUserSkillDTO(userSkillDTOList);
        return userDTO;
    }

    private UserSkillDTO convertToUserSkillDto(UserSkill userSkill) {
        UserSkillDTO userSkillDTO = modelMapper.map(userSkill, UserSkillDTO.class);
        userSkillDTO.setSkillDTO(convertToSkillDto(userSkill.getSkill()));
        return userSkillDTO;
    }

    private SkillDTO convertToSkillDto(Skill skill) {
        return modelMapper.map(skill, SkillDTO.class);
    }

    private User convertToEntity(UserDTO userDTO) {
        return modelMapper.map(userDTO, User.class);
    }

    @Autowired
    @Qualifier("userDao1")
    public void setUserRepo(UserRepositoryCustom userRepo) {
        this.userRepo = userRepo;
    }

}
