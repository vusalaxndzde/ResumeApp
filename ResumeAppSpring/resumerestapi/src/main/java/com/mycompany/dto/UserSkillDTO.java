package com.mycompany.dto;

import com.mycompany.entity.UserSkill;

public class UserSkillDTO {

    private Integer id;
    private Integer power;
    private SkillDTO skillDTO;

    public UserSkillDTO() {
    }

    public UserSkillDTO(UserSkill userSkill) {
        this.id = userSkill.getId();
        this.power = userSkill.getPower();
        this.skillDTO = new SkillDTO(userSkill.getSkill());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public SkillDTO getSkillDTO() {
        return skillDTO;
    }

    public void setSkillDTO(SkillDTO skillDTO) {
        this.skillDTO = skillDTO;
    }

}
