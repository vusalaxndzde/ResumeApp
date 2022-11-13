package com.mycompany.main;

import com.mycompany.dao.inter.UserSkillDaoInter;


public class Main {

    public static void main(String[] args) throws Exception {
        UserSkillDaoInter udi = Context.instanceUserSkillDao();
        System.out.println(udi.getAllUserSkillByUserId(2));
    }

}
