package com.mycompany.main;

import com.mycompany.dao.inter.SkillDaoInter;
import com.mycompany.entity.Skill;


public class Main {

    public static void main(String[] args) throws Exception {
        SkillDaoInter udi = Context.instanceSkillDao();
        System.out.println(udi.getSkillById(1));
        Skill s = new Skill(5, "Kotlin");
        //System.out.println(udi.addSkill(s));
        //System.out.println(udi.updateSkill(s));
        System.out.println(udi.removeSkill(5));
    }

}
