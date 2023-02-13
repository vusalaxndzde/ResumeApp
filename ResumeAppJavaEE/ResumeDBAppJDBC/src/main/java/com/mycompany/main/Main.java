package com.mycompany.main;

import com.mycompany.dao.inter.UserDaoInter;
import com.mycompany.dao.inter.UserSkillDaoInter;
import com.mycompany.entity.Skill;
import com.mycompany.entity.User;
import com.mycompany.entity.UserSkill;


public class Main {

    public static void main(String[] args) throws Exception {
        UserDaoInter udi = Context.instanceUserDao();
        System.out.println(udi.filter("Vusal", "", null));
        
    }

}
