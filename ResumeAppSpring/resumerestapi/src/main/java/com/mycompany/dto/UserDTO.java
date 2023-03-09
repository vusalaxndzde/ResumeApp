package com.mycompany.dto;

import com.mycompany.entity.User;
import com.mycompany.entity.UserSkill;

import java.util.ArrayList;
import java.util.List;

public class UserDTO {

    private Integer id;
    private String name;
    private String surname;
    private List<UserSkillDTO> userSkillDTO;

    public UserDTO() {
    }

    public UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.surname = user.getSurname();

        List<UserSkillDTO> userSkillDTOList = new ArrayList<>();
        List<UserSkill> userSkills = user.getUserSkillList();
        for (UserSkill userSkill : userSkills) {
            userSkillDTOList.add(new UserSkillDTO(userSkill));
        }
        this.userSkillDTO = userSkillDTOList;
    }

    public UserDTO(Integer id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<UserSkillDTO> getUserSkillDTO() {
        return userSkillDTO;
    }

    public void setUserSkillDTO(List<UserSkillDTO> userSkillDTO) {
        this.userSkillDTO = userSkillDTO;
    }

}
