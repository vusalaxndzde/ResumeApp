package com.mycompany.main;

import com.mycompany.dao.inter.UserDaoInter;
import com.mycompany.entity.User;


public class Main {

    public static void main(String[] args) throws Exception {
        UserDaoInter udi = Context.instanceUserDao();
        User u = udi.getById(1);
        System.out.println(u.getName());
    }

}
