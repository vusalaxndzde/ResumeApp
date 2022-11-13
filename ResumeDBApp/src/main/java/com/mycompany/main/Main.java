package com.mycompany.main;

import com.mycompany.entity.User;
import com.mycompany.dao.inter.UserDaoInter;
import java.util.List;


public class Main {

    public static void main(String[] args) throws Exception {
        UserDaoInter udi = Context.instanceUserDao();
        List<User> users = udi.getAll();
        for (User user : users) {
            System.out.println(user);
        }
        System.out.println(udi.getById(1));
    }

}
