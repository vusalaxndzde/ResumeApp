package com.mycompany.dao.inter;

import com.mycompany.entity.Skill;

import java.util.List;

public interface SkillDaoInter {

    public List<Skill> getAllSkill();
    
    public Skill getSkillById(int id);
    
    public boolean updateSkill(Skill s);
    
    public int addSkill(Skill s);
    
    public boolean removeSkill(int id);

}
