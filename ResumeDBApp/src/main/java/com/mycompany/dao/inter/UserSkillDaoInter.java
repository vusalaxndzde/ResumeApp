package com.mycompany.dao.inter;

import com.mycompany.entity.UserSkill;
import java.util.List;

public interface UserSkillDaoInter {
    
    public List<UserSkill> getAllUserSkillByUserId(int userId);
    
    public boolean addUserSkill(UserSkill us);
    
    public boolean removeUserSkill(int id);
    
    public boolean updateUserSkill(UserSkill us);
    
}
