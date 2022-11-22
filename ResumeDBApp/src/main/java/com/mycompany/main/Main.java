package com.mycompany.main;

import com.mycompany.dao.inter.UserSkillDaoInter;
import com.mycompany.entity.Skill;
import com.mycompany.entity.User;
import com.mycompany.entity.UserSkill;


public class Main {

    public static void main(String[] args) throws Exception {
        UserSkillDaoInter udi = Context.instanceUserSkillDao();
        User user = new User(1);
        Skill skill = new Skill(4, "Javascript");
        UserSkill us = new UserSkill(1, user, skill, 5);
        System.out.println(udi.addUserSkill(us));
        
    }

}
