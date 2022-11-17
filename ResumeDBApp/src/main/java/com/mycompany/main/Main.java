package com.mycompany.main;

import com.mycompany.dao.inter.UserDaoInter;


public class Main {

    public static void main(String[] args) throws Exception {
        UserDaoInter udi = Context.instanceUserDao();
        System.out.println(udi.getAll());
    }

}
