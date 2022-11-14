package com.mycompany.main;

import com.mycompany.dao.inter.SkillDaoInter;


public class Main {

    public static void main(String[] args) throws Exception {
        SkillDaoInter udi = Context.instanceSkillDao();
        System.out.println(udi.getAllSkill());
    }

}
