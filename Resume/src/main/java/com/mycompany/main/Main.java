package com.mycompany.main;

import com.mycompany.bean.User;
import com.mycompany.dao.inter.UserDaoInter;


public class Main {

    public static void main(String[] args) throws Exception {
        UserDaoInter udi = Contex.instanceUserDao();
        User user = new User(0, "Natiq", "Haciyev", "+994551111111", "natiq.haciyev@gmail.com");
        udi.addUser(user);
    }

}
