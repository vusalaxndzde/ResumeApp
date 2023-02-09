package com.mycompany.main;

import com.mycompany.dao.inter.UserDaoInter;
import com.mycompany.entity.User;
import java.util.List;


public class Main {

    public static void main(String[] args) throws Exception {
        UserDaoInter udi = Context.instanceUserDao();
        List<User> u = udi.getAll();
        System.out.println(u);
    }

}
