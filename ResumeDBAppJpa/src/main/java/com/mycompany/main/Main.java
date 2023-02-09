package com.mycompany.main;

import com.mycompany.dao.inter.UserDaoInter;
import com.mycompany.entity.User;


public class Main {

    public static void main(String[] args) throws Exception {
        UserDaoInter udi = Context.instanceUserDao();
        User u = udi.getUserByEmail("vusal.axndzde@gmail.com");
        System.out.println(u);
    }

}
