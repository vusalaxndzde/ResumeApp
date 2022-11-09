package com.mycompany.main;

import com.mycompany.bean.User;
import com.mycompany.dao.inter.UserDaoInter;


public class Main {

    public static void main(String[] args) throws Exception {
        UserDaoInter udi = Contex.instanceUserDao();
        System.out.println(udi.getAll());
    }

}
